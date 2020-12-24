package com.example.passio.View.order;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.passio.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class BanChayFragment extends Fragment {
    //public  static ArrayList<GioHangClass> manggiohang;

    Context context;
    View view;
    GridView gridView;
    SanPhamAdapter adapter;
    ArrayList<SanPham> arr_bean;
    DatabaseReference databaseReference;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_banchay, container, false);
        gridView = view.findViewById(R.id.gridview);

        context = this.getActivity();
        loadData();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,arr_bean.get(position).getTensp(),Toast.LENGTH_SHORT).show();
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialogorder);
                TextView name = dialog.findViewById(R.id.name3);
                ImageView img = dialog.findViewById(R.id.img3);
                TextView mota = dialog.findViewById(R.id.mota);
                TextView gia = dialog.findViewById(R.id.gia3);

                final TextView soluong = dialog.findViewById(R.id.soluong);
                final TextView thanhgia = dialog.findViewById(R.id.thanhgia);
                // truyền dữ liệu lên dialog
                name.setText(arr_bean.get(position).getTensp());
                mota.setText(arr_bean.get(position).getMota());
                gia.setText(arr_bean.get(position).getGia()+"");
                img.setImageBitmap(arr_bean.get(position).getImage());

                //tình tiền
                final  Double tien = Double.parseDouble(gia.getText().toString());
                final int sl = Integer.parseInt(soluong.getText().toString());
                String s = Double.toString(tinhTien(tien,sl));
                thanhgia.setText(s);
                //cộng trừ số lượng
                ImageButton cong = dialog.findViewById(R.id.cong);
                ImageButton tru = dialog.findViewById(R.id.tru);
                cong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int so = Integer.parseInt(soluong.getText().toString());
                        so = so+1;
                        soluong.setText(Integer.toString(so));
                        String s = Double.toString(tinhTien(tien,so));
                        thanhgia.setText(s);
                    }
                });
                tru .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int so = Integer.parseInt(soluong.getText().toString());
                        so = so-1;
                        soluong.setText(Integer.toString(so));
                        String s = Double.toString(tinhTien(tien,so));
                        thanhgia.setText(s);
                    }
                });


                dialog.show();
            }

        });

//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
//                Toast.makeText(context,arr_bean.get(position).getTensp(), Toast.LENGTH_SHORT).show();
//                final Dialog dialog = new Dialog(context);
//                dialog.setContentView(R.layout.dialogorder);
//                TextView name = dialog.findViewById(R.id.name3);
//                ImageView img = dialog.findViewById(R.id.img3);
//                TextView mota = dialog.findViewById(R.id.mota);
//                final TextView gia = dialog.findViewById(R.id.gia3);
//                final TextView thanhgia = dialog.findViewById(R.id.thanhgia);
//                final TextView soluong = dialog.findViewById(R.id.soluong);
//                //truyền dữ liệu lên dialog
//                name.setText(arr_bean.get(position).getTensp());
//                gia.setText(arr_bean.get(position).getGia()+"");
//                img.setImageBitmap(arr_bean.get(position).getImage());
//                mota.setText(arr_bean.get(position).getMota());
//                // tính thành tiền
//                final int b = Integer.parseInt(soluong.getText().toString());
//                final Double a = Double.parseDouble(gia.getText().toString());
//
//                final String s=Double.toString(tinhTien(a,b));
//                thanhgia.setText(s);
//                //làm chơi
//                final String masp="";
//                final String tesp="";
//                final Double giasp =0.0;
//                final String hinh="";
//                final String id="";
//
//
//                // số lương
//
//                ImageButton cong = dialog.findViewById(R.id.cong);
//                ImageButton tru = dialog.findViewById(R.id.tru);
//
//                cong.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        int c = Integer.parseInt(soluong.getText().toString());
//                        c=c+1;
//                        if(c<=arr_bean.get(position).getSoluong()){
//                        String s1=Integer.toString(c);
//                        soluong.setText(s1);
//                        String s=Double.toString(tinhTien(a,c));
//                        thanhgia.setText(s);
//                    }}
//                });
//                tru.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        int b = Integer.parseInt(soluong.getText().toString());
//                        b= b-1;
//                        if (b>0){
//                            String s2 = Integer.toString(b);
//                            soluong.setText(s2);
//                            String s=Double.toString(tinhTien(a,b));
//                            thanhgia.setText(s);
//                        }
//
//                    }
//                });
//
//
//                TextView ok= dialog.findViewById(R.id.themgiohang);
//                ok.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                         int sluong = Integer.parseInt(soluong.getText().toString());
//                         int tgia = (int) Double.parseDouble(thanhgia.getText().toString());
//                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
//                        SharedPreferences.Editor editor = preferences.edit();
//                        editor.putInt("soluong", sluong);
//                        editor.putInt("thanhgia", tgia);// value to store
//                        editor.commit();
//                        dialog.cancel();
//                        Intent intent = new Intent(context,Order.class);
//                        startActivity(intent);
//
//                    }
//                });
//
//                ImageView imageView = dialog.findViewById(R.id.close);
//                imageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.cancel();
//                    }
//                });
//
//                // làm chơi
//
//                dialog.show();
//
//            }
//        });
//

        return view;

    }
    public  Double tinhTien(Double a, int b){
        return  a*b;

    }
//    private Double tinhTien(Double a, int b){
//        Double s;
//        s= a*b;
//        return s;
//    }
//    private Double tinhTong(Double a, Double b) {
//        Double s;
//        s = a + b;
//        return s;
//    }

    private void loadData(){
        gridView = view.findViewById(R.id.gridview);
        arr_bean = new ArrayList<>();
        adapter=new SanPhamAdapter(arr_bean, getContext());
        gridView.setAdapter(adapter);
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                for(final DataSnapshot data: dataSnapshot.child("sanpham").getChildren()){
                    final SanPham girdViewBean= data.getValue(SanPham.class);
                    girdViewBean.setMasp(data.getKey());

                    final List<Bitmap> hinh = new ArrayList<>();
                    for (final DataSnapshot hinhanh:dataSnapshot.child("hinhanhsanpham").child(data.getKey()).getChildren()){
                        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child(hinhanh.getValue(String.class));
                        final long ONE_MEGABYTE = 1024*1024;

                        storageReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                            @Override
                            public void onSuccess(byte[] bytes) {
                                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                                hinh.add(bitmap);
                                if (hinh.size()==dataSnapshot.child("hinhanhsanpham").child(data.getKey()).getChildrenCount()){
                                    girdViewBean.setDanhSachHinhAnh(hinh);
                                    girdViewBean.setImage(hinh.get(0));

                                    arr_bean.add(girdViewBean);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        });

                    }
                    girdViewBean.setDanhSachHinhAnh(hinh);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        };
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addListenerForSingleValueEvent(valueEventListener);
    }
}