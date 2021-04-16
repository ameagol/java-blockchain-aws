package com.gellman.JavaBlockchain.core;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;

@Service
public class BlockChain {

    private LinkedList<Block> chain = new LinkedList<Block>();

    public BlockChain(){
         chain.add(setGenesist());
    }

    public Block setGenesist (){
        return new Block(0, LocalDateTime.now(), new JSONObject().append("Header", "Genesis Block"), "0");
    }

    private Block getLatestBlock(){
       return this.chain.get(this.chain.size() - 1);
    }

    public void addBlock(Block newBlock){
        newBlock.setPreviusHash(this.getLatestBlock().getHash());
        newBlock.setHash(newBlock.generateHash());
        this.chain.add(newBlock);
    }

    @Override
    public String toString() {
        return "BlockChain{" +
                "chain=" + chain +
                '}';
    }
}
