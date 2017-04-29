package beans;

import java.util.List;

/**
 * Created by lenovo on 2017/4/20.
 * 描述：
 */

public class SettingAdapterBean {

    /**
     * Level : 0
     * Name : 内卡
     * ValueType : Button
     * IsOpen : true
     * Child : [{"Level":1,"Name":"商户信息设置","ValueType":"Button","IsOpen":true,"Value":"","Child":[]},{"Level":1,"Name":"通讯参数设置","ValueType":"Button","IsOpen":true,"Value":"","Child":[]},{"Level":1,"Name":"交易功能设置","ValueType":"Button","IsOpen":true,"Value":"","Child":[]}]
     * Value :
     */

    private List<SettingBean> Setting;

    public List<SettingBean> getSetting() {
        return Setting;
    }

    public void setSetting(List<SettingBean> Setting) {
        this.Setting = Setting;
    }

    public static class SettingBean {
        private int Level;
        private String Name;
        private String ValueType;
        private boolean IsOpen;
        private String Value;
        /**
         * Level : 1
         * Name : 商户信息设置
         * ValueType : Button
         * IsOpen : true
         * Value :
         * Child : []
         */

        private List<ChildBean> Child;

        public int getLevel() {
            return Level;
        }

        public void setLevel(int Level) {
            this.Level = Level;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getValueType() {
            return ValueType;
        }

        public void setValueType(String ValueType) {
            this.ValueType = ValueType;
        }

        public boolean isIsOpen() {
            return IsOpen;
        }

        public void setIsOpen(boolean IsOpen) {
            this.IsOpen = IsOpen;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            this.Value = Value;
        }

        public List<ChildBean> getChild() {
            return Child;
        }

        public void setChild(List<ChildBean> Child) {
            this.Child = Child;
        }

        public static class ChildBean {
            private int Level;
            private String Name;
            private String ValueType;
            private boolean IsOpen;
            private String Value;
            private List<?> Child;

            public int getLevel() {
                return Level;
            }

            public void setLevel(int Level) {
                this.Level = Level;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getValueType() {
                return ValueType;
            }

            public void setValueType(String ValueType) {
                this.ValueType = ValueType;
            }

            public boolean isIsOpen() {
                return IsOpen;
            }

            public void setIsOpen(boolean IsOpen) {
                this.IsOpen = IsOpen;
            }

            public String getValue() {
                return Value;
            }

            public void setValue(String Value) {
                this.Value = Value;
            }

            public List<?> getChild() {
                return Child;
            }

            public void setChild(List<?> Child) {
                this.Child = Child;
            }
        }
    }
}
