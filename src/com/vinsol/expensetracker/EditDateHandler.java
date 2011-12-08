package com.vinsol.expensetracker;

import java.util.Calendar;

import com.vinsol.expensetracker.utils.DisplayDate;
import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

public class EditDateHandler {
	private TextView text_voice_camera_header_title;
	private Activity activity;

	public EditDateHandler(Context mContext, String timeInMillis) {
		activity = (mContext instanceof Activity) ? (Activity) mContext : null;
		text_voice_camera_header_title = (TextView) activity.findViewById(R.id.text_voice_camera_header_title);
		Calendar mCalendar = Calendar.getInstance();
		mCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		mCalendar.setTimeInMillis(Long.parseLong(timeInMillis));
		
		DisplayDate mDisplayDate = new DisplayDate(mCalendar);
		//TODO
		text_voice_camera_header_title.setText(mDisplayDate.getDisplayDate()+"at "+getDate(mCalendar));
	}

	public EditDateHandler(Context mContext) {
		activity = (mContext instanceof Activity) ? (Activity) mContext : null;
		text_voice_camera_header_title = (TextView) activity.findViewById(R.id.text_voice_camera_header_title);
		text_voice_camera_header_title.setText("Camera Entry");
	}
	
	private String getDate(Calendar tempCalendar) {
		int hour = tempCalendar.get(Calendar.HOUR);
		String minute = Integer.toString(tempCalendar.get(Calendar.MINUTE));
		if (minute.length() == 1) {
			minute = "0" + minute;
		}
		if (hour == 0) {
			hour = 12;
		}
		if (tempCalendar.get(Calendar.MINUTE) != 0){
			if (tempCalendar.get(Calendar.AM_PM) == 1){
				return hour + ":" + minute + " " + "PM";
			}
			if (tempCalendar.get(Calendar.AM_PM) == 0){
				return hour + ":" + minute + " " + "AM";
			}
		}
		else{ 
			if (tempCalendar.get(Calendar.AM_PM) == 1){
				return hour + "" + " " + "PM";
			}
			if (tempCalendar.get(Calendar.AM_PM) == 0){
				return hour + "" + " " + "AM";
			}
		}
		return null;
	}
}
