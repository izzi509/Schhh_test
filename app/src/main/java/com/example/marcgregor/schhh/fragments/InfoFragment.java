package com.example.marcgregor.schhh.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marcgregor.schhh.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Delva on 9/11/2016.
 */
public class InfoFragment extends Fragment {
  //  public static final String ARG_PAGE = "ARG_PAGE";
  TextView tvNomH,tvAddressH;
    ImageView articleDetailImg ;
    View myView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_info, container, false);

        String nom = getActivity().getIntent().getExtras().getString("NAME_KEY");
        String adresse = getActivity().getIntent().getExtras().getString("ADRESS_KEY");
        String imagePath = getActivity().getIntent().getExtras().getString("IMAGE_KEY");

        tvNomH = (TextView) myView.findViewById(R.id.tvNomH);
        tvAddressH= (TextView) myView.findViewById(R.id.tvAddressH);
        articleDetailImg= (ImageView) myView.findViewById(R.id.articleDetailImg);

 /*   public static InfoFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        InfoFragment fragment1 = new InfoFragment();
        return fragment1;
    }*/
        tvNomH.setText(nom);
        tvAddressH.setText(adresse);

        Picasso.with(getContext()).load(String.valueOf(imagePath)).into(articleDetailImg);
        //  usernameTxt.setText(username);

        return myView;
    }

}
