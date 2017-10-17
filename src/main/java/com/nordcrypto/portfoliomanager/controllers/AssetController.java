package com.nordcrypto.portfoliomanager.controllers;

import com.nordcrypto.portfoliomanager.entities.CryptoCurrency;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Andreas Heilig
 * Date: 17.10.2017
 */
@RequestMapping("/api")
@RestController
public class AssetController {
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CryptoCurrency> getAssets() {
        List<CryptoCurrency> cryptoList = new ArrayList<>();
        CryptoCurrency bitcoin = new CryptoCurrency("bitcoin", 4523.12, 12);
        cryptoList.add(bitcoin);
        return cryptoList;
    }
}
