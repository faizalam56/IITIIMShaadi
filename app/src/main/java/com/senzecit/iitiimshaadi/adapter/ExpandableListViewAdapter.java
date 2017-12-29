package com.senzecit.iitiimshaadi.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.senzecit.iitiimshaadi.R;
import com.senzecit.iitiimshaadi.activity.NewUserRegiaterActivity;
import com.senzecit.iitiimshaadi.customdialog.CustomListAdapterDialog;
import com.senzecit.iitiimshaadi.customdialog.Model;
import com.senzecit.iitiimshaadi.slider_dialog.with_list.SliderDialogListLayoutAdapter;
import com.senzecit.iitiimshaadi.slider_dialog.with_list.SliderDialogListLayoutModel;
import com.senzecit.iitiimshaadi.slider_dialog.with_selection.SliderDialogCheckboxLayoutAdapter;
import com.senzecit.iitiimshaadi.slider_dialog.with_selection.SliderDialogCheckboxLayoutModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;



public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context _context;
    LayoutInflater layoutInflater;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    String editName;
    EditText mName;
    TextView mProfileCreatedFor,mAge,mDiet,mDateOfBirth,mMaritalStatus,mDrink,mSmoke,mHeight,mInterest;

    public ExpandableListViewAdapter(Context context, List<String> listDataHeader,
                                        HashMap<String, List<String>> listChildData) {
        this._context = context;
        layoutInflater = LayoutInflater.from(_context);
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);
        //****lchild data items start
        switch (groupPosition) {
            case 0:
                switch (childPosition) {
                    case 0:

                        LayoutInflater infalInflater22 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater22.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout.setHint(childText);

                        mName = (EditText) convertView.findViewById(R.id.idlistitemET);

                        mName.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);



                        break;
                    case 1:
                        LayoutInflater infalInflater1 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater1.inflate(R.layout.list_item_non_editable, null);

                        mProfileCreatedFor = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        mProfileCreatedFor.setText(childText);

                        TextView txtListChildHeader = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader.setText(childText);

                        break;
                    case 2:
                        LayoutInflater infalInflater2 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater2.inflate(R.layout.list_item_non_editable, null);

                        mAge = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        mAge.setText(childText);

                        TextView txtListChildHeader2 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader2.setText(childText);

                        break;
                    case 3:
                        LayoutInflater infalInflater3 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater3.inflate(R.layout.list_item, null);

                        mDiet = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        mDiet.setText(childText);

                        TextView txtListChildHeader3 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader3.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild3);
                                showDiet(mDiet);
                            }
                        });

                        break;
                    case 4:
                        LayoutInflater infalInflater4 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater4.inflate(R.layout.list_item_non_editable, null);

                        mDateOfBirth = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        mDateOfBirth.setText(childText);

                        TextView txtListChildHeader4 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader4.setText(childText);

                        break;
                    case 5:
                        LayoutInflater infalInflater5 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater5.inflate(R.layout.list_item, null);

                        mMaritalStatus = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        mMaritalStatus.setText(childText);

                        TextView txtListChildHeader5 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader5.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild5,100,50);
                                showMaritalStatus(mMaritalStatus);
                            }
                        });

                        break;
                    case 6:
                        LayoutInflater infalInflater6 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater6.inflate(R.layout.list_item, null);

                        final TextView txtListChild6 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild6.setText(childText);

                        mDrink = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        mDrink.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild6,100,50);
                                showDrink(mDrink);
                            }
                        });

                        break;
                    case 7:
                        LayoutInflater infalInflater7 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater7.inflate(R.layout.list_item, null);

                        final TextView txtListChild7 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild7.setText(childText);

                        mSmoke = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        mSmoke.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild7,100,50);
                                showSmoke(mSmoke);
                            }
                        });

                        break;
                    case 8:
                        LayoutInflater infalInflater8 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater8.inflate(R.layout.list_item, null);

                        final TextView txtListChild8 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild8.setText(childText);

                       mHeight = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        mHeight.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild8,100,50);
                                showHeight(mHeight);
                            }
                        });

                        break;
                    case 9:
                        LayoutInflater infalInflater9 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater9.inflate(R.layout.list_item, null);

                        final TextView txtListChild9 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild9.setText(childText);

                        mInterest = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        mInterest.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showSelectableDialog(txtListChild9,100,50);
                                showInterests(mInterest);
                            }
                        });

                        break;
                    case 10:
                        LayoutInflater infalInflater10 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater10.inflate(R.layout.submit_data_button, null);
                        Button saveChanges = convertView.findViewById(R.id.save_changes_button);
                        saveChanges.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //do somethings.
                                saveChangesOfCase_0();
                            }
                        });
                        break;
                }
                break;
            case 1:
                switch (childPosition) {

                    case 0:
                        LayoutInflater infalInflater1 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater1.inflate(R.layout.list_item, null);

                        final TextView txtListChild1 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild1.setText(childText);

                        TextView txtListChildHeader1 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader1.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild1,100,50);
                                showReligion(txtListChild1);
                            }
                        });

                        break;
                    case 1:
                        LayoutInflater infalInflater2 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater2.inflate(R.layout.list_item, null);

                        final TextView txtListChild2 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild2.setText(childText);

                        TextView txtListChildHeader2 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader2.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild2,100,50);
                                showCaste(txtListChild2);
                            }
                        });

                        break;
                    case 2:
                        LayoutInflater infalInflater3 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater3.inflate(R.layout.list_item, null);

                        final TextView txtListChild3 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild3.setText(childText);

                        TextView txtListChildHeader3 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader3.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild3,100,50);
                                showMotherTongue(txtListChild3);
                            }
                        });

                        break;
                    case 3:
                        LayoutInflater infalInflater4 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater4.inflate(R.layout.submit_data_button, null);
                        Button saveChanges = convertView.findViewById(R.id.save_changes_button);
                        saveChanges.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //do somethings.
                            }
                        });
                        break;
                }
                break;
//CONTACT DETAIL
            case 2:
                switch (childPosition){

                    case 0:
                        LayoutInflater infalInflater = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater.inflate(R.layout.list_item_non_editable, null);

                        final TextView txtListChild = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild.setText(childText);

                        TextView txtListChildHeader = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader.setText(childText);
                        break;
                    case 1:
                        LayoutInflater infalInflater1 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater1.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout1 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout1.setHint(childText);

                        EditText editText1 = convertView.findViewById(R.id.idlistitemET);
                        editText1.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                        break;
                    case 2:
                        LayoutInflater infalInflater2 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater2.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout2 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout2.setHint(childText);

                        EditText editText2 = convertView.findViewById(R.id.idlistitemET);
                        editText2.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                        break;
                    case 3:
                        LayoutInflater infalInflater3 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater3.inflate(R.layout.list_item, null);

                        final TextView txtListChild3 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild3.setText(childText);

                        TextView txtListChildHeader3 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader3.setText(childText);

                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild3,100,50);
                                showCountry(txtListChild3);
                            }
                        });
                        break;
                    case 4:
                        LayoutInflater infalInflater4 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater4.inflate(R.layout.list_item, null);

                        final TextView txtListChild4 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild4.setText(childText);

                        TextView txtListChildHeader4 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader4.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild4,100,50);
                                showState(txtListChild4);
                            }
                        });

                        break;
                    case 5:
                        LayoutInflater infalInflater5 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater5.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout5 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout5.setHint(childText);

                        EditText editText5 = convertView.findViewById(R.id.idlistitemET);
                        editText5.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 6:
                        LayoutInflater infalInflater6 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater6.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout6 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout6.setHint(childText);

                        EditText editText6 = convertView.findViewById(R.id.idlistitemET);
                        editText6.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 7:
                        LayoutInflater infalInflater7 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater7.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout7 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout7.setHint(childText);

                        EditText editText7 = convertView.findViewById(R.id.idlistitemET);
                        editText7.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 8:
                        LayoutInflater infalInflater8 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater8.inflate(R.layout.list_item, null);

                        final TextView txtListChild8 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild8.setText(childText);

                        TextView txtListChildHeader8 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader8.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild8,100,50);
                                showCountry(txtListChild8);
                            }
                        });

                        break;
                    case 9:
                        LayoutInflater infalInflater9 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater9.inflate(R.layout.list_item, null);

                        final TextView txtListChild9 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild9.setText(childText);

                        TextView txtListChildHeader9 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader9.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild9,100,50);
                                showState(txtListChild9);
                            }
                        });

                        break;
                    case 10:
                        LayoutInflater infalInflater10 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater10.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout10 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout10.setHint(childText);

                        EditText editText10 = convertView.findViewById(R.id.idlistitemET);
                        editText10.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 11:
                        LayoutInflater infalInflater11 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater11.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout11 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout11.setHint(childText);

                        EditText editText11 = convertView.findViewById(R.id.idlistitemET);
                        editText11.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                        break;
                    case 12:
                        LayoutInflater infalInflater12 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater12.inflate(R.layout.submit_data_button, null);
                        Button saveChanges = convertView.findViewById(R.id.save_changes_button);
                        saveChanges.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //do somethings.
                            }
                        });
                        break;
                }
                break;
            case 3:
                switch (childPosition) {

                    case 0:
                        LayoutInflater infalInflater = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout.setHint(childText);

                        EditText editText = convertView.findViewById(R.id.idlistitemET);
                        editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 1:
                        LayoutInflater infalInflater1 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater1.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout1 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout1.setHint(childText);

                        EditText editText1 = convertView.findViewById(R.id.idlistitemET);
                        editText1.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 2:
                        LayoutInflater infalInflater2 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater2.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout2 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout2.setHint(childText);

                        EditText editText2 = convertView.findViewById(R.id.idlistitemET);
                        editText2.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 3:
                        LayoutInflater infalInflater3 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater3.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout3 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout3.setHint(childText);

                        EditText editText3 = convertView.findViewById(R.id.idlistitemET);
                        editText3.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 4:
                        LayoutInflater infalInflater4 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater4.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout4 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout4.setHint(childText);

                        EditText editText4 = convertView.findViewById(R.id.idlistitemET);
                        editText4.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 5:
                        LayoutInflater infalInflater5 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater5.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout5 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout5.setHint(childText);

                        EditText editText5 = convertView.findViewById(R.id.idlistitemET);
                        editText5.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;

                    case 6:
                        LayoutInflater infalInflater6 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater6.inflate(R.layout.submit_data_button, null);
                        Button saveChanges = convertView.findViewById(R.id.save_changes_button);
                        saveChanges.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //do somethings.
                            }
                        });
                        break;
                }
                break;
            case 4:
                switch (childPosition) {

                    case 0:
                        LayoutInflater infalInflater = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout.setHint(childText);

                        EditText editText = convertView.findViewById(R.id.idlistitemET);
                        editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 1:
                        LayoutInflater infalInflater1 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater1.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout1 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout1.setHint(childText);

                        EditText editText1 = convertView.findViewById(R.id.idlistitemET);
                        editText1.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 2:
                        LayoutInflater infalInflater2 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater2.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout2 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout2.setHint(childText);

                        EditText editText2 = convertView.findViewById(R.id.idlistitemET);
                        editText2.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 3:
                        LayoutInflater infalInflater3 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater3.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout3 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout3.setHint(childText);

                        EditText editText3 = convertView.findViewById(R.id.idlistitemET);
                        editText3.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 4:
                        LayoutInflater infalInflater4 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater4.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout4 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout4.setHint(childText);

                        EditText editText4 = convertView.findViewById(R.id.idlistitemET);
                        editText4.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 5:
                        LayoutInflater infalInflater5 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater5.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout5 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout5.setHint(childText);

                        EditText editText5 = convertView.findViewById(R.id.idlistitemET);
                        editText5.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 6:
                        LayoutInflater infalInflater6 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater6.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout6 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout6.setHint(childText);

                        EditText editText6 = convertView.findViewById(R.id.idlistitemET);
                        editText6.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 7:
                        LayoutInflater infalInflater7 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater7.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout7 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout7.setHint(childText);

                        EditText editText7 = convertView.findViewById(R.id.idlistitemET);
                        editText7.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 8:
                        LayoutInflater infalInflater8 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater8.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout8 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout8.setHint(childText);

                        EditText editText8 = convertView.findViewById(R.id.idlistitemET);
                        editText8.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 9:
                        LayoutInflater infalInflater9 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater9.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout9 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout9.setHint(childText);

                        EditText editText9 = convertView.findViewById(R.id.idlistitemET);
                        editText9.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 10:
                        LayoutInflater infalInflater10 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater10.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout10 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout10.setHint(childText);

                        EditText editText10 = convertView.findViewById(R.id.idlistitemET);
                        editText10.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 11:
                        LayoutInflater infalInflater11 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater11.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout11 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout11.setHint(childText);

                        EditText editText11 = convertView.findViewById(R.id.idlistitemET);
                        editText11.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 12:
                        LayoutInflater infalInflater12 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater12.inflate(R.layout.list_item, null);

                        final TextView txtListChild12 = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild12.setText(childText);

                        TextView txtListChildHeader12 = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader12.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild12,100,50);
                                showAnnualIncome(txtListChild12);
                            }
                        });
                        break;
                    case 13:
                        LayoutInflater infalInflater13 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater13.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout13 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout13.setHint(childText);

                        EditText editText13 = convertView.findViewById(R.id.idlistitemET);
                        editText13.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;

                    case 14:
                        LayoutInflater infalInflater14 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater14.inflate(R.layout.submit_data_button, null);
                        Button saveChanges = convertView.findViewById(R.id.save_changes_button);
                        saveChanges.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //do somethings.
                            }
                        });
                        break;
                }
                break;
            case 5:
                switch (childPosition){

                    case 0:
                        LayoutInflater infalInflater = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater.inflate(R.layout.list_item_thirdtype, null);

//                        EditText textInputLayout = (EditText) convertView.findViewById(R.id.idTextInputLayout);
//                        textInputLayout.setHint(childText);

                        EditText editText = convertView.findViewById(R.id.idlistitemET);
                        editText.setText("Say Something...");
                        editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 1:
                        LayoutInflater infalInflater1 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater1.inflate(R.layout.submit_data_button, null);
                        Button saveChanges = convertView.findViewById(R.id.save_changes_button);
                        saveChanges.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //do somethings.
                            }
                        });
                        break;
                }
                break;
            case 6:
                switch (childPosition){

                    case 0:
                        LayoutInflater infalInflater = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout.setHint(childText);

                        EditText editText = convertView.findViewById(R.id.idlistitemET);
                        editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 1:
                        LayoutInflater infalInflater1 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater1.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout1 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout1.setHint(childText);

                        EditText editText1 = convertView.findViewById(R.id.idlistitemET);
                        editText1.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 2:
                        LayoutInflater infalInflater2 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater2.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout2 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout2.setHint(childText);

                        EditText editText2 = convertView.findViewById(R.id.idlistitemET);
                        editText2.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 3:
                        LayoutInflater infalInflater3 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater3.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout3 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout3.setHint(childText);

                        EditText editText3 = convertView.findViewById(R.id.idlistitemET);
                        editText3.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 4:
                        LayoutInflater infalInflater4 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater4.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout4 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout4.setHint(childText);

                        EditText editText4 = convertView.findViewById(R.id.idlistitemET);
                        editText4.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 5:
                        LayoutInflater infalInflater5 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater5.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout5 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout5.setHint(childText);

                        EditText editText5 = convertView.findViewById(R.id.idlistitemET);
                        editText5.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 6:
                        LayoutInflater infalInflater6 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater6.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout6 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout6.setHint(childText);

                        EditText editText6 = convertView.findViewById(R.id.idlistitemET);
                        editText6.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 7:
                        LayoutInflater infalInflater7 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater7.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout7 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout7.setHint(childText);

                        EditText editText7 = convertView.findViewById(R.id.idlistitemET);
                        editText7.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 8:
                        LayoutInflater infalInflater8 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater8.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout8 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout8.setHint(childText);

                        EditText editText8 = convertView.findViewById(R.id.idlistitemET);
                        editText8.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 9:
                        LayoutInflater infalInflater9 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater9.inflate(R.layout.list_item_secondtype, null);

                        TextInputLayout textInputLayout9 = (TextInputLayout) convertView.findViewById(R.id.idTextInputLayout);
                        textInputLayout9.setHint(childText);

                        EditText editText9 = convertView.findViewById(R.id.idlistitemET);
                        editText9.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

                        break;
                    case 10:
                        LayoutInflater infalInflater10 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater10.inflate(R.layout.submit_data_button, null);
                        Button saveChanges = convertView.findViewById(R.id.save_changes_button);
                        saveChanges.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //do somethings.
                            }
                        });
                        break;
                }
                break;
            case 7:
                switch (childPosition) {

                    case 0:
                        LayoutInflater infalInflater = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater.inflate(R.layout.list_item, null);

                        final TextView txtListChild = (TextView) convertView
                                .findViewById(R.id.childItemTV);
                        txtListChild.setText(childText);

                        TextView txtListChildHeader = (TextView) convertView
                                .findViewById(R.id.childItemTVheader);
                        txtListChildHeader.setText(childText);
                        convertView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showDialog(txtListChild,100,50);
                            }
                        });

                        break;
                    case 1:
                        LayoutInflater infalInflater1 = (LayoutInflater) this._context
                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = infalInflater1.inflate(R.layout.submit_data_button, null);
                        Button saveChanges = convertView.findViewById(R.id.save_changes_button);
                        saveChanges.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //do somethings.
                            }
                        });
                        break;

                }
                break;
        }

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.profileGroupTV);
        lblListHeader.setTypeface(null, Typeface.NORMAL);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    public Vector<Dialog> dialogs = new Vector<Dialog>();
    private void showDialog(List<String> dataList, final TextView txtListChild) {

        int d_width = 100;
        int d_height = 50;
        final ArrayList<SliderDialogListLayoutModel> models = new ArrayList<SliderDialogListLayoutModel>();
        if(dataList.size()>0){
            for (int i = 0; i < dataList.size(); i++) {
                SliderDialogListLayoutModel model = new SliderDialogListLayoutModel();
                model.setName(dataList.get(i));
                models.add(model);
            }
        }else {
            for (int i = 0; i < 20; i++) {
                SliderDialogListLayoutModel model = new SliderDialogListLayoutModel();
                model.setName("senzecit " + i);
                models.add(model);
            }
        }

        final Dialog dialog = new Dialog(_context, R.style.CustomDialog);//,R.style.CustomDialog
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

//        View view = getLayoutInflater().inflate(R.layout.slider_dialog_list_layout, null);
        View view = layoutInflater.inflate(R.layout.slider_dialog_list_layout, null);

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(_context);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.custom_list);
//		final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        ((Button) view.findViewById(R.id.button_done)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        final SliderDialogListLayoutAdapter clad1 = new SliderDialogListLayoutAdapter(_context, models);
        recyclerView.setAdapter(clad1);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        dialogs.add(dialog);
        dialog.show();

        WindowManager wm = (WindowManager) _context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        Window window = dialog.getWindow();
        window.setGravity(Gravity.RIGHT);
        window.setLayout(width - d_width, height - d_height);

        clad1.setOnItemClickListener(new SliderDialogListLayoutAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, String id) {
                int positionInList = position % models.size();

                txtListChild.setText(models.get(positionInList).getName());
                dialog.dismiss();
            }
        });

    }

    public Vector<Dialog> selectableDialogs = new Vector<Dialog>();
    private void showSelectableDialog(List<String> dataList, final TextView txtListChild)
    {
        int d_width = 100;
        int d_height = 50;
        final StringBuilder selectedQualification = new StringBuilder();
        final View[] parentListView = {null};
        final ArrayList<SliderDialogCheckboxLayoutModel> models = new ArrayList<SliderDialogCheckboxLayoutModel>();
        if(dataList.size()>0){
            for (int i = 0; i < dataList.size(); i++) {
                SliderDialogCheckboxLayoutModel model = new SliderDialogCheckboxLayoutModel();
                model.setName(dataList.get(i));
                models.add(model);
            }
        }else {
            for (int i = 0; i < 20; i++) {
                SliderDialogCheckboxLayoutModel model = new SliderDialogCheckboxLayoutModel();
                model.setName("senzecit " + i);
                models.add(model);
            }
        }

        final Dialog dialog = new Dialog(_context, R.style.CustomDialog);//,R.style.CustomDialog
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        View view = layoutInflater.inflate(R.layout.slider_dialog_checkbox_layout, null);

        final ListView listView = (ListView) view.findViewById(R.id.custom_list);
        Button doneBtn = (Button)view.findViewById(R.id.button_done);


        SliderDialogCheckboxLayoutAdapter clad1 = new SliderDialogCheckboxLayoutAdapter(_context, models);
        listView.setAdapter(clad1);


        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        selectableDialogs.add(dialog);
        dialog.show();

        WindowManager wm = (WindowManager) _context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        Window window = dialog.getWindow();
        window.setGravity(Gravity.RIGHT);
        window.setLayout(width - d_width, height - d_height);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < models.size(); i++) {

                    parentListView[0] = getViewByPosition(i, listView);
                    CheckBox checkBox = (CheckBox)parentListView[0].findViewById(R.id.idCheckbox);
                    TextView textView = (TextView)parentListView[0].findViewById(R.id.idText);

                    if (checkBox.isChecked()){

                        selectedQualification.append(textView.getText().toString()+", ");
                    }

                }
                txtListChild.setText(selectedQualification.toString());
                dialog.dismiss();
//             Toast.makeText(MainActivity.this, "Data is : "+slideText.getText(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition
                + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }

    // GET and SET Value
    public void showDiet(TextView textView){
        List<String> list = new ArrayList<>();
        list.add("Vegetarian");
        list.add("Jain");
        list.add("Vegan");
        list.add("Non Vegetarian");

        showDialog(list, textView);
    }
    public void showMaritalStatus(TextView textView){
        List<String> list = new ArrayList<>();
        list.add("Never Married");
        list.add("Divorced");
        list.add("Divorced Awaited");
        list.add("Widow/Widower");
        list.add("Any");

        showDialog(list, textView);
    }
    public void showDrink(TextView textView){
        List<String> list = new ArrayList<>();
        list.add("No");
        list.add("Yes");
        list.add("Occasionally");

        showDialog(list, textView);
    }
    public void showSmoke(TextView textView){
        List<String> list = new ArrayList<>();
        list.add("No");
        list.add("Yes");
        list.add("Occasionally");

        showDialog(list, textView);
    }
    public void showHeight(TextView textView){
        List<String> list = new ArrayList<>();

        list.add("4 ft 5in (134 cm)");
        list.add("4 ft 6in (137 cm)");
        list.add("4 ft 7in (139 cm)");
        list.add("4 ft 8in (142 cm)");
        list.add("4 ft 9in (144 cm)");
        list.add("4 ft 10in (147 cm)");
        list.add("4 ft 11in (149 cm)");
        list.add("5 ft 0in (152 cm)");
        list.add("5 ft 1in (154 cm)");
        list.add("5 ft 2in (157 cm)");
        list.add("5 ft 3in (160 cm)");
        list.add("5 ft 4in (162 cm)");
        list.add("5 ft 5in (165 cm)");
        list.add("5 ft 6in (167 cm)");
        list.add("5 ft 7in (170 cm)");
        list.add("5 ft 8in (172 cm)");
        list.add("5 ft 9in (175 cm)");
        list.add("5 ft 10in (177 cm)");
        list.add("5 ft 11in (180 cm)");
        list.add("6 ft 0in (182 cm)");
        list.add("6 ft 1in (185 cm)");
        list.add("6 ft 2in (187 cm)");
        list.add("6 ft 3in (190 cm)");
        list.add("6 ft 4in (193 cm)");
        list.add("6 ft 5in (195 cm)");
        list.add("6 ft 6in (198 cm)");
        list.add("6 ft 7in (200 cm)");
        list.add("6 ft 8in (203 cm)");


        showDialog(list, textView);
    }
    public void showInterests(TextView textView){
        List<String> list = new ArrayList<>();
        list.add("Music");
        list.add("Books");
        list.add("Travelling");
        list.add("Cooking");
        list.add("Movies");
        list.add("Sports");
        list.add("Shopping");
        list.add("Net Surfing");
        list.add("Others");

        showSelectableDialog(list, textView);
    }

    //RELIGIOUS BACKGROUND
    public void showReligion(TextView textView){
        List<String> list = new ArrayList<>();
        list.add("Hindu");
        list.add("Muslim");
        list.add("Christian");
        list.add("Sikh");
        list.add("Parsi");
        list.add("Jain");
        list.add("Buddhist");
        list.add("Jewish");
        list.add("Other");

        showDialog(list, textView);
    }
    public void showCaste(TextView textView){
        List<String> list = new ArrayList<>();
        list.add("Caste1");
        list.add("Caste2");
        list.add("Caste3");
        list.add("Caste4");

        showDialog(list, textView);
    }
    public void showMotherTongue(TextView textView){
        List<String> list = new ArrayList<>();
        list.add("Assamese");
        list.add("Bengali");
        list.add("English");
        list.add("Gujarati");
        list.add("Hindi");

        showDialog(list, textView);
    }

    //CONTACT US
    public void showCountry(TextView textView){
        List<String> list = new ArrayList<>();
        list.add("India");
        list.add("Russia");
        list.add("China");
        list.add("America");
        list.add("USA");

        showDialog(list, textView);
    }
    public void showState(TextView textView){
        List<String> list = new ArrayList<>();
        list.add("State-1");
        list.add("State-2");
        list.add("State-3");
        list.add("State-4");
        list.add("State-5");

        showDialog(list, textView);
    }
    //EDUCATION & CARREER
    public void showAnnualIncome(TextView textView){
        List<String> list = new ArrayList<>();
        list.add("less than 10 LPA");
        list.add("11-20 LPA");
        list.add("21-30 LPA");
        list.add("31-50 LPA");
        list.add("51-75 LPA");
        list.add("76-100 LPA");
        list.add("More than 100 LPA");
        list.add("Not Disclosed");

        showDialog(list, textView);
    }



    private void saveChangesOfCase_0(){
        String name = mName.getText().toString();
//        String diet = mDiet.getText().toString();

        System.out.println("Selected value: "+name.length());
    }
}
