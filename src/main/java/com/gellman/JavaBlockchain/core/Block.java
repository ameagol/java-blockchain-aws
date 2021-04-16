package com.gellman.JavaBlockchain.core;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;

import java.time.LocalDateTime;

@Getter
@Setter
public class Block {

    private Integer index;
    private String previusHash;
    private JSONObject data;
    private String hash;
    private LocalDateTime timestamp;

    public Block(Integer index, LocalDateTime timestamp,  JSONObject data, String previusHash) {
        this.index = index;
        this.previusHash = previusHash;
        this.data = data;
        this.hash = this.generateHash();;
        this.timestamp = timestamp;
    }

    public String generateHash(){
        return DigestUtils.sha256Hex(
                this.index + this.previusHash + this.timestamp + data.toString()
        ).toString();
    }

    @Override
    public String toString() {
        return "Block{" +
                "index=" + index +
                ", previusHash='" + previusHash + '\'' +
                ", data=" + data +
                ", hash='" + hash + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
