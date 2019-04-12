package com.gunner.model.dto;

import java.io.Serializable;

public class Token implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = -754659525548951914L;
    private String signature;
    private long timestamp;

    /**
     * 包含签名以及时间戳的构造体
     * @param signature
     * @param timestamp
     */
    public Token(String signature, long timestamp) {
        if (signature == null)
            throw new IllegalArgumentException("signature can not be null");

        this.timestamp = timestamp;
        this.signature = signature;
    }

    /**
     * 仅包含签名的构造体
     * @param signature
     */
    public Token(String signature) {
        if (signature == null)
            throw new IllegalArgumentException("signature can not be null");

        this.signature = signature;
    }

    /**
     * 获取签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 获取时间戳
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * 返回签名的哈希码
     */
    public int hashCode() {
        return signature.hashCode();
    }

    /**
     * 验证两个Token是否相同
     * timestamp 不予考虑, 因为就算 timestamp 不同也认为是相同的 token.
     */
    public boolean equals(Object object) {
        if (object instanceof Token)
            return ((Token)object).signature.equals(this.signature);
        return false;
    }

    @Override
    public String toString() {
        return "Token [signature=" + signature + ", timestamp=" + timestamp
                + "]";
    }

}