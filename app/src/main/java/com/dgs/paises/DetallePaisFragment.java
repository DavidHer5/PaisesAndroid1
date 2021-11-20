package com.dgs.paises;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dgs.paises.databinding.FragmentDetallePaisBinding;
import com.dgs.paises.placeholder.PlaceholderContent;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class DetallePaisFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private FragmentDetallePaisBinding binding;
    private PlaceholderContent.Pais mPais;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPais = getArguments().getParcelable("pais");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetallePaisBinding.inflate(inflater, container,false);

        ImageView iv = binding.foto;
        iv.setImageResource(getImageId(mPais.foto));
        TextView tv = binding.descripcion;
        tv.setText(mPais.detalles);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    private int getImageId(String imagePath) {
        String imageName = imagePath.substring(imagePath.lastIndexOf("/")+1, imagePath.lastIndexOf("."));
        return getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
    }
}