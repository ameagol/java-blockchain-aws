package com.gellman.JavaBlockchain.build;

import com.gellman.JavaBlockchain.core.Block;
import com.gellman.JavaBlockchain.core.BlockChain;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Slf4j
@Component
public class createChain {

    @Autowired
    private BlockChain blockChain;

    @PostConstruct
    public void init(){

        blockChain.addBlock(new Block(1, LocalDateTime.now(), new JSONObject().put("Valor",100.32),""));

        blockChain.addBlock(new Block(2, LocalDateTime.now(), new JSONObject().put("Valor",23.10),""));
        log.info(blockChain.toString());
    }
}
