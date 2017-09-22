package crypto.mappers;

import crypto.model.arbitrageModels.ArbitrageModel;
import crypto.model.cryptoVolumeModel.CryptoVolume;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by aaron on 9/20/17.
 */
@Mapper
public interface VolumeMapper {

    String INSERT_VOLUME_STATS = "INSERT INTO cryptopeek.volume_stats (symbol, to_currency, " +
            "total_volume, total_value) VALUES (#{symbol}, #{to_currency}, #{total_volume}, #{total_value})";

    @Insert(INSERT_VOLUME_STATS)
    public void addVolumeStatsToDb(CryptoVolume cryptoVolume);
}
