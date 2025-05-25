package com.app.backend.controller;

import com.app.backend.config.rest.ResponseFactory;
import com.app.backend.model.BalanceDto;
import com.app.backend.model.Wallet;
import com.app.backend.model.WalletDto;
import com.app.backend.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class WalletController {
    @Autowired
    WalletRepository walletRepository;
    @PostMapping("/private/wallet/list")
    ResponseEntity wallets(){
        return ResponseFactory.clone(walletRepository.findAll());
    }
    @PostMapping("/private/wallet/save")
    ResponseEntity saveWallet(@RequestBody WalletDto param) throws Exception {
        Wallet wallet;
        if(Objects.equals(param.getChain(), "ALL")){
            wallet = walletRepository.findByBtcAddressAndEthAddress(param.getBtcAddress(), param.getEthAddress());
        }else if(Objects.equals(param.getChain(), "ETH") || Objects.equals(param.getChain(), "BSC") || Objects.equals(param.getChain(), "POLYGON")){
            wallet = walletRepository.findByEthAddress(param.getEthAddress());
        }else{
            wallet = walletRepository.findByTronAddress(param.getTronAddress());
        }
        if(wallet != null){
            throw new Exception("Account has already created");
        }
        wallet = new Wallet();
        wallet.setBtcAddress(param.getBtcAddress());
        wallet.setEthAddress(param.getEthAddress());
        wallet.setTronAddress(param.getTronAddress());
        wallet.setBalance(param.getBalance());
        return ResponseFactory.clone(walletRepository.save(wallet));
    }

    @PostMapping("/private/wallet/balance")
    ResponseEntity saveBalance(@RequestBody BalanceDto param) throws Exception {
        Wallet wallet;
        if(param.getChain().equals("TRON")){
            wallet = this.walletRepository.findByTronAddress(param.getWalletAddress());
        }else{
            wallet = this.walletRepository.findByEthAddress(param.getWalletAddress());
        }
        if(null == wallet){
            throw new Exception("Account not found");
        }
        wallet.setBalance(param.getTotalBalance());
        return ResponseFactory.clone(walletRepository.save(wallet));
    }
}
