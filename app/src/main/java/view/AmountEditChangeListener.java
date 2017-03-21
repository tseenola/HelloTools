package view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class AmountEditChangeListener implements TextWatcher {
    private boolean status = true;
    private EditText et3;
    private StringBuffer sb = new StringBuffer();

    public AmountEditChangeListener(EditText et) {
        this.et3 = et;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (status) {
            status = false;
            et3.setText(dealString(s.toString()));
            et3.setSelection(et3.length());
        } else {
            status = true;
        }
    }

    private String dealString(String arg1) {
        if (sb.length() != 0) {
            sb.delete(0, sb.length());
        }
        if (arg1.length() == 0) {
            return "";
        } else if (arg1.length() == 1) {
            if (arg1.equals(".")) {
                return "";
            }
            if (arg1.equals("0")) {
                return "";
            }
            double re = Double.parseDouble(arg1);
            re = re / 100;
            return re + "";
        } else if (arg1.length() == 2) {
            if (arg1.equals("00")) {
                return "";
            }
        } else {
            sb.append(arg1);
            if (sb.length() - 1 - sb.indexOf(".") == 4) {
                double content = Double.parseDouble(sb.toString());
                if (content < 0.1) {
                    sb.delete(0, 3);
                    sb.insert(1, ".");
                } else if (content < 1) {
                    sb.delete(0, 2);
                    sb.insert(2, ".");
                } else {
                    int index = sb.indexOf(".");
                    sb.deleteCharAt(index);
                    sb.insert(index + 2, ".");
                }
            } else if (sb.length() - 1 - sb.indexOf(".") == 3) {
                if (arg1.charAt(0) == '0') {
                    if (arg1.charAt(2) == '0') {
                        sb.deleteCharAt(2);
                    } else {
                        sb.delete(0, 2);
                        sb.insert(1, ".");
                    }
                } else {
                    int index = sb.indexOf(".");
                    sb.deleteCharAt(index);
                    sb.insert(index + 1, ".");
                }
            } else {
                int index = sb.indexOf(".");
                if (index > 1) {
                    sb.deleteCharAt(index);
                    sb.insert(index - 1, ".");
                } else {
                    if (sb.charAt(0) == '0') {
                        sb.insert(2, "0");
                    } else {
                        sb.deleteCharAt(index);
                        sb.insert(index - 1, ".");
                        sb.insert(index - 1, "0");
                    }
                }
            }
        }
        return sb.toString();
    }
}
