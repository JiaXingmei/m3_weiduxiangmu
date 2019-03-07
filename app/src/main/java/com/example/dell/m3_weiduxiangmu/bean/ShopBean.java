package com.example.dell.m3_weiduxiangmu.bean;

import java.util.List;

public class ShopBean
{

    /**
     * result : [{"commodityId":5,"commodityName":"双头两用修容笔","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 5
         * commodityName : 双头两用修容笔
         * count : 1
         * pic : http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg
         * price : 39
         */

        private int commodityId;
        private String commodityName;
        private String count;
        private String pic;
        private int price;
        //给复选框设置状态
        private boolean ischeck=false;

        public boolean isIscheck() {
            return ischeck;
        }

        public void setIscheck(boolean ischeck) {
            this.ischeck = ischeck;
        }

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
