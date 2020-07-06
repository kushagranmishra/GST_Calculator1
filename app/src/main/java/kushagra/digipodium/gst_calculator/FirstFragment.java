package kushagra.digipodium.gst_calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private EditText awog;
    private EditText gstp;
    private Button btnCalc;
    private Button btnReset;
    View view;
    private EditText tv1;
    private EditText tv2;
    private int c;
    private Button imgNext;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        awog = view.findViewById(R.id.awog);
        gstp = view.findViewById(R.id.gstp);

        btnCalc = view.findViewById(R.id.btnCalc);
        btnReset = view.findViewById(R.id.btnReset);
        tv1 = view.findViewById(R.id.tv1);
        tv2 = view.findViewById(R.id.tv2);
        imgNext = view.findViewById(R.id.imgNext);
        c = 0;
btnCalc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String p = awog.getText().toString();
        String r = gstp.getText().toString();

        if (p.length() == 0) {
            Toast.makeText(getActivity(), "Enter Amount without GST", Toast.LENGTH_SHORT).show();
        }
        if (r.length() == 0) {
            Toast.makeText(getActivity(), "Enter GST Rate", Toast.LENGTH_SHORT).show();
        }
        else
        {
Double p1=Double.parseDouble(p);
Double r1=Double.parseDouble(r);
Double awg1=p1*((100+r1)/100);
Double gstr1=awg1-p1;
tv1.setText(String.valueOf(awg1));
tv2.setText(String.valueOf(gstr1));
        }
    }
});
imgNext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String p = tv1.getText().toString();
        String r = gstp.getText().toString();
        if (p.length() == 0) {
            Toast.makeText(getActivity(), "Enter Amount with GST", Toast.LENGTH_SHORT).show();
        }
        if (r.length() == 0) {
            Toast.makeText(getActivity(), "Enter GST Rate", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Double p1=Double.parseDouble(p);
            Double r1=Double.parseDouble(r);
            Double awog1=p1*(100/(100+r1));
            Double gstr1 =p1-awog1;
            awog.setText(String.valueOf(awog1));
            tv2.setText(String.valueOf(gstr1));

        }
    }
});
btnReset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        awog.setText(String.valueOf(c));
        gstp.setText(String.valueOf(c));
        tv1.setText(String.valueOf(c));
        tv2.setText(String.valueOf(c));
    }
});

    }
}