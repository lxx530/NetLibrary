package com.comaiot.net.library.device.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;

public class FaceverifyEntity extends BaseEntity implements Serializable {

    private int error_code;
    private String error_msg;
    private long log_id;
    private long timestamp;
    private int cached;
    private Result result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCached() {
        return cached;
    }

    public void setCached(int cached) {
        this.cached = cached;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "FaceverifyEntity{" +
                "error_code=" + error_code +
                ", error_msg='" + error_msg + '\'' +
                ", log_id=" + log_id +
                ", timestamp=" + timestamp +
                ", cached=" + cached +
                ", result=" + result +
                '}';
    }

    public class Result implements Serializable {
        private Thresholds thresholds;
        private float face_liveness;
        private Face_list[] face_list;

        public Thresholds getThresholds() {
            return thresholds;
        }

        public void setThresholds(Thresholds thresholds) {
            this.thresholds = thresholds;
        }

        public float getFace_liveness() {
            return face_liveness;
        }

        public void setFace_liveness(float face_liveness) {
            this.face_liveness = face_liveness;
        }

        public Face_list[] getFace_list() {
            return face_list;
        }

        public void setFace_list(Face_list[] face_list) {
            this.face_list = face_list;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "thresholds=" + thresholds +
                    ", face_liveness=" + face_liveness +
                    ", face_list=" + Arrays.toString(face_list) +
                    '}';
        }
    }

    public class Thresholds implements Serializable {
        @SerializedName("frr_1e-4")
        private float frr_1e_4;
        @SerializedName("frr_1e-3")
        private float frr_1e_3;
        @SerializedName("frr_1e-2")
        private float frr_1e_2;

        public float getFrr_1e_4() {
            return frr_1e_4;
        }

        public void setFrr_1e_4(float frr_1e_4) {
            this.frr_1e_4 = frr_1e_4;
        }

        public float getFrr_1e_3() {
            return frr_1e_3;
        }

        public void setFrr_1e_3(float frr_1e_3) {
            this.frr_1e_3 = frr_1e_3;
        }

        public float getFrr_1e_2() {
            return frr_1e_2;
        }

        public void setFrr_1e_2(float frr_1e_2) {
            this.frr_1e_2 = frr_1e_2;
        }

        @Override
        public String toString() {
            return "Thresholds{" +
                    "frr_1e_4=" + frr_1e_4 +
                    ", frr_1e_3=" + frr_1e_3 +
                    ", frr_1e_2=" + frr_1e_2 +
                    '}';
        }
    }

    public class Face_list implements Serializable {
        private String face_token;                              //人脸图片的唯一标识
        private Location location;                              //人脸在图片中的位置
        private double face_probability;                        //人脸置信度，范围【0~1】，代表这是一张人脸的概率，0最小、1最大。
        private Angle angle;                                    //人脸旋转角度参数
        private Liveness liveness;                          //脸型，当face_field包含faceshape时返回

        public String getFace_token() {
            return face_token;
        }

        public void setFace_token(String face_token) {
            this.face_token = face_token;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public double getFace_probability() {
            return face_probability;
        }

        public void setFace_probability(double face_probability) {
            this.face_probability = face_probability;
        }

        public Angle getAngle() {
            return angle;
        }

        public void setAngle(Angle angle) {
            this.angle = angle;
        }

        public Liveness getLiveness() {
            return liveness;
        }

        public void setLiveness(Liveness liveness) {
            this.liveness = liveness;
        }

        @Override
        public String toString() {
            return "Face_list{" +
                    "face_token='" + face_token + '\'' +
                    ", location=" + location +
                    ", face_probability=" + face_probability +
                    ", angle=" + angle +
                    ", liveness=" + liveness +
                    '}';
        }
    }

    public class Location implements Serializable {
        private double left;                               //人脸区域离左边界的距离
        private double top;                                //人脸区域离上边界的距离
        private double width;                              //人脸区域的宽度
        private double height;                             //人脸区域的高度
        private long rotation;                           //人脸框相对于竖直方向的顺时针旋转角，[-180,180]

        public double getLeft() {
            return left;
        }

        public void setLeft(double left) {
            this.left = left;
        }

        public double getTop() {
            return top;
        }

        public void setTop(double top) {
            this.top = top;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public long getRotation() {
            return rotation;
        }

        public void setRotation(long rotation) {
            this.rotation = rotation;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "left=" + left +
                    ", top=" + top +
                    ", width=" + width +
                    ", height=" + height +
                    ", rotation=" + rotation +
                    '}';
        }
    }

    public class Angle implements Serializable {
        private double yaw;                             //三维旋转之左右旋转角[-90(左), 90(右)]
        private double pitch;                           //三维旋转之俯仰角度[-90(上), 90(下)]
        private double roll;                            //平面内旋转角[-180(逆时针), 180(顺时针)]

        public double getYaw() {
            return yaw;
        }

        public void setYaw(double yaw) {
            this.yaw = yaw;
        }

        public double getPitch() {
            return pitch;
        }

        public void setPitch(double pitch) {
            this.pitch = pitch;
        }

        public double getRoll() {
            return roll;
        }

        public void setRoll(double roll) {
            this.roll = roll;
        }

        @Override
        public String toString() {
            return "Angle{" +
                    "yaw=" + yaw +
                    ", pitch=" + pitch +
                    ", roll=" + roll +
                    '}';
        }
    }

    public class Liveness implements Serializable {
        private float faceliveness;
        private float livemapscore;

        public float getFaceliveness() {
            return faceliveness;
        }

        public void setFaceliveness(float faceliveness) {
            this.faceliveness = faceliveness;
        }

        public float getLivemapscore() {
            return livemapscore;
        }

        public void setLivemapscore(float livemapscore) {
            this.livemapscore = livemapscore;
        }

        @Override
        public String toString() {
            return "Liveness{" +
                    "faceliveness=" + faceliveness +
                    ", livemapscore=" + livemapscore +
                    '}';
        }
    }
}
