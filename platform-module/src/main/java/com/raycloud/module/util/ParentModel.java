package com.raycloud.module.util;

import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 16-9-24.
 */
public class ParentModel {

    private List<Parent> array;

    public List<Parent> getArray() {
        return array;
    }

    public void setArray(List<Parent> array) {
        this.array = array;
    }

    /*最外层*/
    public static class Parent{

        private String title;

        private List<FirstNavBean> firstNav;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<FirstNavBean> getFirstNav() {
            return firstNav;
        }

        public void setFirstNav(List<FirstNavBean> firstNav) {
            this.firstNav = firstNav;
        }

    }

    /*第一层*/
    public static class FirstNavBean {
        private String icon;
        private String title;
        /**
         * color : #C40000
         * href : //list.tmall.hk/search_product.htm?auction_tag=13186&area=b2c&acm=lb-zebra-34359-425774.1003.8.519251&q=%B1%A3%CA%AA%B2%B9%CB%AE&spm=a2222.1279144.z6654ak.c543"&code=gbk&scm=1003.8.lb-zebra-34359-425774.ITEM_14455544749810_519251
         * title : 保湿补水
         */

        private List<SecondNavBean> secondNav;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<SecondNavBean> getSecondNav() {
            return secondNav;
        }

        public void setSecondNav(List<SecondNavBean> secondNav) {
            this.secondNav = secondNav;
        }


    }

    /* 第二层navBean*/
    public static class SecondNavBean {
        private String color;
        private String href;
        private String title;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
