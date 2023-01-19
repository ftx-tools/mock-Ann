package com.finantix.mock.hsbc.ann.UrlConstants;

import java.util.ArrayList;
import java.util.List;

import com.finantix.mock.hsbc.ann.model.AlertVariableDTO;
import com.finantix.mock.hsbc.ann.model.AnNDTO;

public class Test {

    public static void main(String[] args) {

        AnNDTO dto = new AnNDTO();
        dto.setRequestId("IR_10000001");
        dto.setFromSystem("Payment/I&R");
        dto.setCategory("OnlineTrading/I&R");
        dto.setUseCase("AccountOpening");
        dto.setBusinessId("uniqueDocID");
        dto.setLocale("en_GB"); // en_GB ch_HK ch_CN
        List<AlertVariableDTO> variables = new ArrayList<>();

        AlertVariableDTO alertVal1DTO = new AlertVariableDTO("Subject", "Metaverse Stock Recommendations", "string");
        AlertVariableDTO alertVal2DTO = new AlertVariableDTO("Summary",
                "Metaverse Stock Recommendations. Metaverse is a virtual shared space thatincludes virtual words..", "string");
        AlertVariableDTO alertVal3DTO = new AlertVariableDTO("MsgBody", "Metaverse is a virtual shared space that includes virtual words...", "string");
        AlertVariableDTO alertVal4DTO = new AlertVariableDTO("Pic1URL", "\"https://www.xxxx", "string");
        AlertVariableDTO alertVal5DTO = new AlertVariableDTO("NeoURL",
                "https://wpb-confluence.systems.uk.hsbc/pages/resumedraft.action?draftId=1820198305&draftShareId=ccf876f9-43c1-47b2-aa2e9187b5b71177&",
                "string");
        variables.add(alertVal1DTO);
        variables.add(alertVal2DTO);
        variables.add(alertVal3DTO);
        variables.add(alertVal4DTO);
        variables.add(alertVal5DTO);
        dto.setVariables(variables);
        // dto.setAssetClass("Debt Product");
        dto.setBookingCenter("Hong Kong");
        dto.setPublicationFrequency("montly");
        dto.setPublicationCategory("Investment products");
        // dto.setMarketsUnderlying(Arrays.asList("US", "HK"));

        System.err.println("DTO" + dto.toString());
    }

}
