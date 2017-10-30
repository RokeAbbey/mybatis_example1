package mappers;

import org.apache.ibatis.annotations.Param;
import roles.Spitter;
import roles.Spittle;

import java.util.Collection;
import java.util.List;

public interface SpittleMapper {
    List<Spittle> getSpittleByOwner(Spitter spitter);
    void addSpittleToSpitter(Spittle spittle);
    void addSpittlesToSpitter(@Param("spittles") Collection<Spittle> spittles);
}
