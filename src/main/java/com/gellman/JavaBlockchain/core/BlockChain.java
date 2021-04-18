package com.gellman.JavaBlockchain.core;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;

@Service
@Slf4j
public class BlockChain {

    private LinkedList<Block> chain = new LinkedList<Block>();

    public BlockChain(){
         chain.add(setGenesist());
    }

    public Block setGenesist (){
        return new Block(0, LocalDateTime.now(), new JSONObject().put("Header", "Genesis Block"), "0");
    }

    private Block getLatestBlock(){
       return this.chain.get(this.chain.size() - 1);
    }

    public void addBlock(Block newBlock){
        newBlock.setPreviusHash(this.getLatestBlock().getHash());
        newBlock.setHash(newBlock.generateHash());
        this.chain.add(newBlock);
    }

    public Boolean validateChain(){
        return this.chain.stream().anyMatch(
                block -> {

                    if(!block.getHash().equals(block.generateHash())) {
                        log.info("Invalid Hash " + block.getHash() + " != " + block.generateHash());
                        return false;
                    }

                    if(!this.chain.get(block.getIndex()-1).generateHash().equals(block.getPreviusHash())){
                        log.info("Invalid Hash " + this.chain.get(block.getIndex()-1).generateHash() + " != " + block.getPreviusHash() );
                        return  false;
                    }

                    return true;
                });
    }

    /**
     * For Test Porposes, this will inject invalid data in a valid block on Chain
     * @param temperedData
     * @param index
     */
    public void compromiseChain(JSONObject temperedData, Integer index){
        this.chain.get(index).setData(temperedData);
    }

    @Override
    public String toString() {
        return "BlockChain{" +
                "chain=" + chain +
                '}';
    }
}
