package in.ashokit.mapper;

import org.modelmapper.ModelMapper;

import in.ashokit.dto.CountryDto;
import in.ashokit.entity.CountryEntity;

public class CountryMapper {

	public static final ModelMapper mapper = new ModelMapper();

	public static CountryDto convertToDto(CountryEntity entity) {
		return mapper.map(entity, CountryDto.class);
	}

	public static CountryEntity covertToEntity(CountryDto dto) {
		return mapper.map(dto, CountryEntity.class);
	}

}
