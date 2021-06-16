package com.tcm.community.mapper;

import com.tcm.community.model.TlTp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TlTpMapper {

    TlTp getTlTpByTlid(Long tlid);

    void saveTlTp(TlTp tlTp);

    void updateTlTp(TlTp tlTp);

    void delete(Integer tlpid);

}
