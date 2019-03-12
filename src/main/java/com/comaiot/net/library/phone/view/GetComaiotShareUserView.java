package com.comaiot.net.library.phone.view;

import com.comaiot.net.library.device.bean.YDBase;
import com.comaiot.net.library.device.bean.YDShareUser;
import com.comaiot.net.library.device.view.ComaiotView;

public interface GetComaiotShareUserView extends ComaiotView {
    void onGetComaiotShareUserSucc(YDBase<YDShareUser[]> data);
}
