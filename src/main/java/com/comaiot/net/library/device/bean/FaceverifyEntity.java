//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

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
    private FaceverifyEntity.Result result;

    public FaceverifyEntity() {
    }

    public int a() {
        return this.error_code;
    }

    public void a(int var1) {
        this.error_code = var1;
    }

    public String b() {
        return this.error_msg;
    }

    public void a(String var1) {
        this.error_msg = var1;
    }

    public long c() {
        return this.log_id;
    }

    public void a(long var1) {
        this.log_id = var1;
    }

    public long d() {
        return this.timestamp;
    }

    public void b(long var1) {
        this.timestamp = var1;
    }

    public int e() {
        return this.cached;
    }

    public void c(int var1) {
        this.cached = var1;
    }

    public FaceverifyEntity.Result f() {
        return this.result;
    }

    public void a(FaceverifyEntity.Result var1) {
        this.result = var1;
    }

    public String toString() {
        return "FaceverifyEntity{error_code=" + this.error_code + ", error_msg='" + this.error_msg + '\'' + ", log_id=" + this.log_id + ", timestamp=" + this.timestamp + ", cached=" + this.cached + ", result=" + this.result + '}';
    }

    public class Liveness implements Serializable {
        private float faceliveness;
        private float livemapscore;

        public Liveness() {
        }

        public float a() {
            return this.faceliveness;
        }

        public void a(float var1) {
            this.faceliveness = var1;
        }

        public float b() {
            return this.livemapscore;
        }

        public void b(float var1) {
            this.livemapscore = var1;
        }

        public String toString() {
            return "Liveness{faceliveness=" + this.faceliveness + ", livemapscore=" + this.livemapscore + '}';
        }
    }

    public class Angle implements Serializable {
        private double yaw;
        private double pitch;
        private double roll;

        public Angle() {
        }

        public double a() {
            return this.yaw;
        }

        public void a(double var1) {
            this.yaw = var1;
        }

        public double b() {
            return this.pitch;
        }

        public void b(double var1) {
            this.pitch = var1;
        }

        public double c() {
            return this.roll;
        }

        public void c(double var1) {
            this.roll = var1;
        }

        public String toString() {
            return "Angle{yaw=" + this.yaw + ", pitch=" + this.pitch + ", roll=" + this.roll + '}';
        }
    }

    public class Location implements Serializable {
        private double left;
        private double top;
        private double width;
        private double height;
        private long rotation;

        public Location() {
        }

        public double a() {
            return this.left;
        }

        public void a(double var1) {
            this.left = var1;
        }

        public double b() {
            return this.top;
        }

        public void b(double var1) {
            this.top = var1;
        }

        public double c() {
            return this.width;
        }

        public void c(double var1) {
            this.width = var1;
        }

        public double d() {
            return this.height;
        }

        public void d(double var1) {
            this.height = var1;
        }

        public long e() {
            return this.rotation;
        }

        public void a(long var1) {
            this.rotation = var1;
        }

        public String toString() {
            return "Location{left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + ", rotation=" + this.rotation + '}';
        }
    }

    public class Face_list implements Serializable {
        private String face_token;
        private FaceverifyEntity.Location location;
        private double face_probability;
        private FaceverifyEntity.Angle angle;
        private FaceverifyEntity.Liveness liveness;

        public Face_list() {
        }

        public String a() {
            return this.face_token;
        }

        public void a(String var1) {
            this.face_token = var1;
        }

        public FaceverifyEntity.Location b() {
            return this.location;
        }

        public void a(FaceverifyEntity.Location var1) {
            this.location = var1;
        }

        public double c() {
            return this.face_probability;
        }

        public void a(double var1) {
            this.face_probability = var1;
        }

        public FaceverifyEntity.Angle d() {
            return this.angle;
        }

        public void a(FaceverifyEntity.Angle var1) {
            this.angle = var1;
        }

        public FaceverifyEntity.Liveness e() {
            return this.liveness;
        }

        public void a(FaceverifyEntity.Liveness var1) {
            this.liveness = var1;
        }

        public String toString() {
            return "Face_list{face_token='" + this.face_token + '\'' + ", location=" + this.location + ", face_probability=" + this.face_probability + ", angle=" + this.angle + ", liveness=" + this.liveness + '}';
        }
    }

    public class Thresholds implements Serializable {
        @SerializedName("frr_1e-4")
        private float frr_1e_4;
        @SerializedName("frr_1e-3")
        private float frr_1e_3;
        @SerializedName("frr_1e-2")
        private float frr_1e_2;

        public Thresholds() {
        }

        public float a() {
            return this.frr_1e_4;
        }

        public void a(float var1) {
            this.frr_1e_4 = var1;
        }

        public float b() {
            return this.frr_1e_3;
        }

        public void b(float var1) {
            this.frr_1e_3 = var1;
        }

        public float c() {
            return this.frr_1e_2;
        }

        public void c(float var1) {
            this.frr_1e_2 = var1;
        }

        public String toString() {
            return "Thresholds{frr_1e_4=" + this.frr_1e_4 + ", frr_1e_3=" + this.frr_1e_3 + ", frr_1e_2=" + this.frr_1e_2 + '}';
        }
    }

    public class Result implements Serializable {
        private FaceverifyEntity.Thresholds thresholds;
        private float face_liveness;
        private FaceverifyEntity.Face_list[] face_list;

        public Result() {
        }

        public FaceverifyEntity.Thresholds a() {
            return this.thresholds;
        }

        public void a(FaceverifyEntity.Thresholds var1) {
            this.thresholds = var1;
        }

        public float b() {
            return this.face_liveness;
        }

        public void a(float var1) {
            this.face_liveness = var1;
        }

        public FaceverifyEntity.Face_list[] c() {
            return this.face_list;
        }

        public void a(FaceverifyEntity.Face_list[] var1) {
            this.face_list = var1;
        }

        public String toString() {
            return "Result{thresholds=" + this.thresholds + ", face_liveness=" + this.face_liveness + ", face_list=" + Arrays.toString(this.face_list) + '}';
        }
    }
}
