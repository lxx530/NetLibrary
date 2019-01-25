package com.comaiot.net.library.device.bean;

import java.io.Serializable;
import java.util.Arrays;

public class CheckPersonEntity extends BaseEntity implements Serializable {

    private int error_code;
    private String error_msg;
    private long log_id;
    private long timestamp;
    private int cached;
    private Result result;

    public int getCached() {
        return cached;
    }

    public void setCached(int cached) {
        this.cached = cached;
    }

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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CheckPersonEntity{" +
                "error_code=" + error_code +
                ", error_msg='" + error_msg + '\'' +
                ", log_id=" + log_id +
                ", timestamp=" + timestamp +
                ", cached=" + cached +
                ", result=" + result +
                '}';
    }

    public class Face_list implements Serializable {
        private String face_token;                              //人脸图片的唯一标识
        private Location location;                              //人脸在图片中的位置
        private double face_probability;                        //人脸置信度，范围【0~1】，代表这是一张人脸的概率，0最小、1最大。
        private Angle angle;                                    //人脸旋转角度参数
        private Face_shape face_shape;                          //脸型，当face_field包含faceshape时返回
        private Face_type face_type;                            //真实人脸/卡通人脸 face_field包含facetype时返回

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

        public Face_shape getFace_shape() {
            return face_shape;
        }

        public void setFace_shape(Face_shape face_shape) {
            this.face_shape = face_shape;
        }

        public Face_type getFace_type() {
            return face_type;
        }

        public void setFace_type(Face_type face_type) {
            this.face_type = face_type;
        }

        @Override
        public String toString() {
            return "Face_list{" +
                    "face_token='" + face_token + '\'' +
                    ", location=" + location +
                    ", face_probability=" + face_probability +
                    ", angle=" + angle +
                    ", face_shape=" + face_shape +
                    ", face_type=" + face_type +
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

    public class Face_shape implements Serializable {
        private String type;                                //square: 正方形 triangle:三角形 oval: 椭圆 heart: 心形 round: 圆形
        private double probability;                         //置信度，范围【0~1】，代表这是人脸形状判断正确的概率，0最小、1最大。

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getProbability() {
            return probability;
        }

        public void setProbability(double probability) {
            this.probability = probability;
        }

        @Override
        public String toString() {
            return "Race{" +
                    "type='" + type + '\'' +
                    ", probability=" + probability +
                    '}';
        }
    }

    public class Face_type implements Serializable {
        private String type;                                //human: 真实人脸 cartoon: 卡通人脸
        private double probability;                         //人脸类型判断正确的置信度，范围【0~1】，0代表概率最小、1代表最大。

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getProbability() {
            return probability;
        }

        public void setProbability(double probability) {
            this.probability = probability;
        }

        @Override
        public String toString() {
            return "Face_type{" +
                    "type='" + type + '\'' +
                    ", probability=" + probability +
                    '}';
        }
    }

    public class Result implements Serializable {
        private int face_num;                               //检测到的图片中的人脸数量
        private Face_list[] face_list;                       //人脸信息列表

        public int getFace_num() {
            return face_num;
        }

        public void setFace_num(int face_num) {
            this.face_num = face_num;
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
                    "face_num=" + face_num +
                    ", face_list=" + Arrays.toString(face_list) +
                    '}';
        }
    }
}
