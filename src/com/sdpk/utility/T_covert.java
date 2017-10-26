package com.sdpk.utility;

import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordPre;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-26 下午3:19:55
 * 类说明
 * 集中所有的转换类
 */

public class T_covert {
  
  public PaikeRecord Prp2Pr(PaikeRecordPre prp){
    PaikeRecord pr = new PaikeRecord();
    pr.setUuid("Prp2Pr经过转换");
    pr.setClaUuid(prp.getClaUuid());
    pr.setCourseUuid(prp.getCourseUuid());
    pr.setEmpUuid(prp.getEmpUuid());
    pr.setClassroomUuid(prp.getClassroomUuid());
    pr.setKeDateTime(prp.getKeDateTime());
    pr.setKeStartTime(prp.getKeStartTime());
    pr.setKeLongTime(prp.getKeLongTime());
    pr.setStatus(prp.getStatus());

    return pr;
  }//end method Prp2Pr

}//end class T_covert
