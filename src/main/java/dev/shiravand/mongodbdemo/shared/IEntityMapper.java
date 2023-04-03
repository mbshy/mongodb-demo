package dev.shiravand.mongodbdemo.shared;

public interface IEntityMapper<ENT, DTO> {
    public ENT toEntity(DTO dto);
    public DTO toDto(ENT entity);

}
