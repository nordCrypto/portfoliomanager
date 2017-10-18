package com.nordcrypto.portfoliomanager.controllers;

import com.nordcrypto.portfoliomanager.models.Asset;
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

    @RequestMapping(value = "/assets", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Asset> getAssets() {
        List<Asset> cryptoList = new ArrayList<>();
        Asset bitcoin = new Asset("bitcoin");
        cryptoList.add(bitcoin);
        return cryptoList;
    }

}
