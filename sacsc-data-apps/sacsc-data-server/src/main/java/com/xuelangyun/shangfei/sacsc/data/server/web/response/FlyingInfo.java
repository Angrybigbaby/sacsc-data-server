package com.xuelangyun.shangfei.sacsc.data.server.web.response;

import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlightCas;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlightCms;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlightHistoryFault;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlyingInfo;
import lombok.Data;

import java.util.List;

/**
 * @author zijian.qjd
 * @since 2024/11/21
 */
@Data
public class FlyingInfo {

    private List<CsRunFlyingInfo> csRunFlyingInfos;
    private List<CsRunFlightCms> csRunFlightCms;
    private List<CsRunFlightCas> csRunFlightCas;
    private List<CsRunFlightHistoryFault> csRunFlightHistoryFaults;
}
