package dev.shiravand.mongodbdemo.shared;

public interface IEntityMapper<M, D> {
    public M toEntity(D dto);
    public D toDto(M entity);

}
