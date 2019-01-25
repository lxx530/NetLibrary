package com.comaiot.net.library.device.view;

import com.comaiot.net.library.device.bean.ArogaBean;

public interface QueryArogaUserView extends ComaiotView {
    void onQueryArogaUserNumberSucc(ArogaBean<ArogaBean.Data> bean);
}
