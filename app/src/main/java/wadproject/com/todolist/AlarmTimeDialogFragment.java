package wadproject.com.todolist;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlarmTimeDialogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlarmTimeDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlarmTimeDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlarmTimeDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlarmTimeDialogFragment newInstance(String param1, String param2) {
        AlarmTimeDialogFragment fragment = new AlarmTimeDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AlarmTimeDialogFragment() {
        // Required empty public constructor
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
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //Use the current time as the default values for the picker.
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        Button showAlarm = (Button)getActivity().findViewById(R.id.showAlarmDialog);



        //Create a new instance of TimePickerDialog and return it.
        if(showAlarm.performClick() == true) {
            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }else{
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

    }
    public void onDateSet(DatePicker view, int year, int month, int day) {
        wadproject.com.todolist.myNumberPicker days = (wadproject.com.todolist.myNumberPicker)getActivity().findViewById(R.id.alarmdays);
        wadproject.com.todolist.myNumberPicker months = (wadproject.com.todolist.myNumberPicker)getActivity().findViewById(R.id.alarmmonth);
        wadproject.com.todolist.myNumberPicker years = (wadproject.com.todolist.myNumberPicker)getActivity().findViewById(R.id.alarmyear);
        days.setValue(day);
        months.setValue(month+1);
        years.setValue(year);
    }




    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        wadproject.com.todolist.myNumberPicker sethours = (wadproject.com.todolist.myNumberPicker)getActivity().findViewById(R.id.hours);
        wadproject.com.todolist.myNumberPicker setMins = (wadproject.com.todolist.myNumberPicker)getActivity().findViewById(R.id.mins);
        sethours.setValue(hourOfDay);
       setMins.setValue(minute);

    }

    /*// TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    *//**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     *//*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }*/

}
