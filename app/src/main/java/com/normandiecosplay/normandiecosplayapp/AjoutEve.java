package com.normandiecosplay.normandiecosplayapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment; /*Penser à enlever le support.v4 pour les fragments*/
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.normandiecosplay.normandiecosplayapp.AjoutEvenement.PARAM_SOURCE;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AjoutEve.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AjoutEve#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AjoutEve extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button btnajoutevenement;
    private String nomNewEvenement;
    private EditText texte;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AjoutEve() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AjoutEve.
     */
    // TODO: Rename and change types and number of parameters
    public static AjoutEve newInstance(String param1, String param2) {
        AjoutEve fragment = new AjoutEve();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vue = inflater.inflate(R.layout.fragment_ajout_eve, container, false);
        btnajoutevenement = vue.findViewById(R.id.button33);
        texte = (EditText) vue.findViewById(R.id.nomEve);
        btnajoutevenement.setOnClickListener(new View.OnClickListener() {


                                                  public void onClick(View view) {
                                                      SQLiteDatabase db = new Base(getActivity()).getWritableDatabase();
                                                      nomNewEvenement=(texte.getText()).toString();

                                                      if(!nomNewEvenement.isEmpty()){
                                                          try {
                                                              db.execSQL("insert into Evenement (nom_eve) values (?);", new String[]{nomNewEvenement});
                                                              //db.rawQuery("insert into Evenement (nom_eve) values ('nomNewEvenement');", new String[0]);
                                                          } catch (Throwable t) {
                                                              t.printStackTrace();
                                                          }
                                                          FragmentManager fragmentManager = getFragmentManager();
                                                          FragmentTransaction fragmentTransaction =
                                                                  fragmentManager.beginTransaction();
                                                          fragmentTransaction.replace(R.id.calque, new ListeEve());
                                                          fragmentTransaction.commit();
                                                      }
                                                      else{
                                                          Toast.makeText(getActivity(), "Marty, il faut remplir le champ!",Toast.LENGTH_LONG).show();
                                                      }

                                                  }


                                              }
        );

        return vue;
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
