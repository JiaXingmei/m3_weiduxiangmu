package com.example.dell.m3_weiduxiangmu.bean;

import java.util.List;

public class ZujiBean {

    /**
     * result : [{"browseNum":2,"browseTime":1551816850000,"commodityId":5,"commodityName":"双头两用修容笔","masterPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/1.jpg","price":39,"userId":60},{"browseNum":1,"browseTime":1551816850000,"commodityId":17,"commodityName":"化妆镜","masterPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/1.jpg","price":31,"userId":60},{"browseNum":1,"browseTime":1551815875000,"commodityId":29,"commodityName":"秋冬新款平底毛毛豆豆鞋加绒单鞋一脚蹬懒人鞋休闲","masterPic":"http://mobile.bwstudent.com/images/small/commodity/nx/ddx/5/1.jpg","price":278,"userId":60},{"browseNum":1,"browseTime":1551815875000,"commodityId":23,"commodityName":"小白鞋 女款 时尚百搭休闲板鞋","masterPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/1.jpg","price":139,"userId":60},{"browseNum":1,"browseTime":1550782521000,"commodityId":145,"commodityName":"如熙新款男鞋韩版学生时尚百搭潮流低帮男帆布鞋简约英伦风舒适男板鞋轻便耐磨系带潮鞋","masterPic":"http://mobile.bwstudent.com/images/small/commodity/nx/nfbx/4/1.jpg","price":119,"userId":60},{"browseNum":2,"browseTime":1550777809000,"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","masterPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/1.jpg","price":3499,"userId":60},{"browseNum":1,"browseTime":1550251888000,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","masterPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg","price":39,"userId":60}]
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
         * browseNum : 2
         * browseTime : 1551816850000
         * commodityId : 5
         * commodityName : 双头两用修容笔
         * masterPic : http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/1.jpg
         * price : 39
         * userId : 60
         */

        private int browseNum;
        private long browseTime;
        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int userId;

        public int getBrowseNum() {
            return browseNum;
        }

        public void setBrowseNum(int browseNum) {
            this.browseNum = browseNum;
        }

        public long getBrowseTime() {
            return browseTime;
        }

        public void setBrowseTime(long browseTime) {
            this.browseTime = browseTime;
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

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
