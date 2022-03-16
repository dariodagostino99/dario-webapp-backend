package com.dario.webapp.backend.demo.currencies.feign;

import com.dario.webapp.backend.demo.authorization.model.NomicsCurrency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "Nomics", url = "https://api.nomics.com/v1")
public interface NomicsFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/currencies/ticker?key=8a6bec95403a2522455925d63c3397c25330a8ab&ids=ETH,BTC&interval=1d,30d&convert=USD&platform-currency=ETH&per-page=100&page=0")
    List<NomicsCurrency> getNomicsCurrency();
}
