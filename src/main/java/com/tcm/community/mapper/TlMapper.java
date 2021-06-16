package com.tcm.community.mapper;

import com.tcm.community.model.Tl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TlMapper {

    List<Tl> getVisitorHomepage(int offset,int limit);

    int getTlCount();//dynamic sql when have only one para , must add @Param("userid")  is alias

    void saveTl(Tl tl);

    void updateTl(Tl tl);

    void delete(Integer tlid);

}
