$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/01_Login.feature");
formatter.feature({
  "name": "PC login",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Login to GWPC",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Valid"
    }
  ]
});
formatter.step({
  "name": "PC URL is available",
  "keyword": "Given "
});
formatter.step({
  "name": "user launches URL and enters username\u003cusername\u003e, password\u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "user should be successfully logged into PC",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "su",
        "gw"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login to GWPC",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Valid"
    }
  ]
});
formatter.step({
  "name": "PC URL is available",
  "keyword": "Given "
});
formatter.match({
  "location": "PCStepDefinition.pcAvailable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user launches URL and enters usernamesu, passwordgw",
  "keyword": "When "
});
formatter.match({
  "location": "PCStepDefinition.loginToPC(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be successfully logged into PC",
  "keyword": "Then "
});
formatter.match({
  "location": "PCStepDefinition.pcLoggedInSuccessfully()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("Include/features/02_AccountCreation.feature");
formatter.feature({
  "name": "Account creation feature feature",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@AccountCreation"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Create a new account",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Valid"
    }
  ]
});
formatter.step({
  "name": "user is logged into PC",
  "keyword": "Given "
});
formatter.step({
  "name": "user initiates account creation by entering company name\u003ccompanyname\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "user enters address\u003caddress1\u003e, city\u003ccity\u003e,state\u003cstate\u003e, zipcode\u003czipcode\u003e, addresstype\u003caddresstype\u003e, organizationname\u003corganizationname\u003e, producercode\u003cproducercode\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "new account should be created successfully",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "companyname",
        "address1",
        "city",
        "state",
        "zipcode",
        "addresstype",
        "organizationname",
        "producercode"
      ]
    },
    {
      "cells": [
        "PWCTest",
        "OLD EVERETT NEIGHBORHOOD",
        "Austin",
        "Texas",
        "73301",
        "Business",
        "Carpenters Insurance",
        "501-002554 Carpenters Insurance"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Create a new account",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AccountCreation"
    },
    {
      "name": "@Valid"
    }
  ]
});
formatter.step({
  "name": "user is logged into PC",
  "keyword": "Given "
});
formatter.match({
  "location": "PCStepDefinition.pcLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user initiates account creation by entering company namePWCTest",
  "keyword": "When "
});
formatter.match({
  "location": "PCStepDefinition.searchAccount(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters addressOLD EVERETT NEIGHBORHOOD, cityAustin,stateTexas, zipcode73301, addresstypeBusiness, organizationnameCarpenters Insurance, producercode501-002554 Carpenters Insurance",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.createNewAccount(String,String,String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "new account should be created successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "PCStepDefinition.accountCreatedSuccessfully()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("Include/features/04_NewSubmission_GL.feature");
formatter.feature({
  "name": "New Submission for General Liability",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@NewSubmissionGL"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Create a new submission for General Liability",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Open AccountNumber and Account Summary page displayed",
  "keyword": "Given "
});
formatter.step({
  "name": "User does Draft submission with the details QutoeType\u003cQutoeType\u003e, BaseState\u003cBaseState\u003e, LOB\u003cLOB\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "user selects Offering\u003cOfferingSelection\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "User enters TermType\u003cTermType\u003e,TaxID\u003cTaxID\u003e,IndustryCode\u003cIndustryCode\u003e,OrganizationType\u003cOrganizationType\u003e in Policy info",
  "keyword": "And "
});
formatter.step({
  "name": "user selects coverage info",
  "keyword": "And "
});
formatter.step({
  "name": "user enters exposure details IndexNumber\u003cIndexNumber\u003e,LocationName\u003cLocationName\u003e,ClassCode\u003cClassCode\u003e,Basis\u003cBasis\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "user clicks on Quote button",
  "keyword": "And "
});
formatter.step({
  "name": "user clicks on Issue Policy",
  "keyword": "And "
});
formatter.step({
  "name": "The policy should be active",
  "keyword": "Then "
});
formatter.step({
  "name": "User is able to view policy",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "QutoeType",
        "BaseState",
        "LOB",
        "OfferingSelection",
        "TermType",
        "TaxID",
        "IndustryCode",
        "OrganizationType",
        "IndexNumber",
        "LocationName",
        "ClassCode",
        "Basis"
      ]
    },
    {
      "cells": [
        "Full Application",
        "Texas",
        "General Liability",
        "GL Standard",
        "Other",
        "85-4723169",
        "0740",
        "Individual",
        "0",
        "1",
        "0005",
        "10000"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Create a new submission for General Liability",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@NewSubmissionGL"
    }
  ]
});
formatter.step({
  "name": "Open AccountNumber and Account Summary page displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "PCStepDefinition.openAccount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User does Draft submission with the details QutoeTypeFull Application, BaseStateTexas, LOBGeneral Liability",
  "keyword": "When "
});
formatter.match({
  "location": "PCStepDefinition.DraftSubmission(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects OfferingGL Standard",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.selectOffering(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters TermTypeOther,TaxID85-4723169,IndustryCode0740,OrganizationTypeIndividual in Policy info",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.UpdatePolicyInfo(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects coverage info",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.updateCoverageInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters exposure details IndexNumber0,LocationName1,ClassCode0005,Basis10000",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.updateExposure(String,Object,Object,Object)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on Quote button",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.clickQuoteBtn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on Issue Policy",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.clickIssue()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The policy should be active",
  "keyword": "Then "
});
formatter.match({
  "location": "PCStepDefinition.ActivePolicy()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is able to view policy",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.ViewPolicy()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("Include/features/08_ChangePolicy_GL.feature");
formatter.feature({
  "name": "Policy Change feature file",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@PolicyChange"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Create Policy Change for GL Product",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Open PolicyNumber and Policy Summary page displayed",
  "keyword": "Given "
});
formatter.step({
  "name": "user triggers start PolicyChange transaction and enters EffectiveDate\u003cEffectiveDate\u003e,ChangeDescription\u003cChangeDescription\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "user add additional Location and enter following details Address1\u003cAddress1\u003e,City\u003cCity\u003e,State\u003cState\u003e,ZipCode\u003cZipCode\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "user add Exposure and enter following details IndexNumber\u003cIndexNumber\u003e, LocationName\u003cLocationName\u003e,ClassCode\u003cClassCode\u003e,Basis\u003cBasis\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "user clicks on Quote button",
  "keyword": "And "
});
formatter.step({
  "name": "user clicks on Issue Policy Change",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "EffectiveDate",
        "ChangeDescription",
        "Address1",
        "City",
        "State",
        "ZipCode",
        "IndexNumber",
        "LocationName",
        "ClassCode",
        "Basis"
      ]
    },
    {
      "cells": [
        "12/10/2020",
        "PolicyChange",
        "3919 State St",
        "Evans",
        "Colorado",
        "80620",
        "1",
        "2",
        "0006",
        "10000"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Create Policy Change for GL Product",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@PolicyChange"
    }
  ]
});
formatter.step({
  "name": "Open PolicyNumber and Policy Summary page displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "PCStepDefinition.openPolicyNumber()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user triggers start PolicyChange transaction and enters EffectiveDate12/10/2020,ChangeDescriptionPolicyChange",
  "keyword": "When "
});
formatter.match({
  "location": "PCStepDefinition.startPolicyChange(String,Object)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user add additional Location and enter following details Address13919 State St,CityEvans,StateColorado,ZipCode80620",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.addLocationDetails(String,Object,Object,Object)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user add Exposure and enter following details IndexNumber1, LocationName2,ClassCode0006,Basis10000",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.addExposureDetails(String,Object,Object,Object)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on Quote button",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.clickQuoteBtn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on Issue Policy Change",
  "keyword": "And "
});
formatter.match({
  "location": "PCStepDefinition.clickIssueChange()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("Include/features/09_PolicyCancel_Now_GL.feature");
formatter.feature({
  "name": "Policy Cancel Now",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@PolicyCancelNow"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Cancelling a policy",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Valid"
    }
  ]
});
formatter.step({
  "name": "user is logged into PC",
  "keyword": "Given "
});
formatter.step({
  "name": "user initiates policy cancellation with source\u003csource\u003e,reason\u003creason\u003e for a policy to be cancelled",
  "keyword": "When "
});
formatter.step({
  "name": "policy should be cancelled successfully",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "source",
        "reason"
      ]
    },
    {
      "cells": [
        "Insurer",
        "Fraud"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Cancelling a policy",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@PolicyCancelNow"
    },
    {
      "name": "@Valid"
    }
  ]
});
formatter.step({
  "name": "user is logged into PC",
  "keyword": "Given "
});
formatter.match({
  "location": "PCStepDefinition.pcLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user initiates policy cancellation with sourceInsurer,reasonFraud for a policy to be cancelled",
  "keyword": "When "
});
formatter.match({
  "location": "PCStepDefinition.policyCancelNow(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "policy should be cancelled successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "PCStepDefinition.policyCancelSuccessfully()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("Include/features/11_PolicyReinstatement_GL.feature");
formatter.feature({
  "name": "Policy Reinstatement",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@PolicyReinstatement"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Policy Reinstatement",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Valid"
    }
  ]
});
formatter.step({
  "name": "user is logged into PC",
  "keyword": "Given "
});
formatter.step({
  "name": "user initiates policy reinstatement with reason\u003creason\u003e for a policy",
  "keyword": "When "
});
formatter.step({
  "name": "policy should be reinstated successfully",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "reason"
      ]
    },
    {
      "cells": [
        "Other"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Policy Reinstatement",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@PolicyReinstatement"
    },
    {
      "name": "@Valid"
    }
  ]
});
formatter.step({
  "name": "user is logged into PC",
  "keyword": "Given "
});
formatter.match({
  "location": "PCStepDefinition.pcLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user initiates policy reinstatement with reasonOther for a policy",
  "keyword": "When "
});
formatter.match({
  "location": "PCStepDefinition.policyReinstatement(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "policy should be reinstated successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "PCStepDefinition.policyReinstatedSuccessfully()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("Include/features/17_Logout.feature");
formatter.feature({
  "name": "Logout feature",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Logout"
    }
  ]
});
formatter.scenario({
  "name": "Logout",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Logout"
    }
  ]
});
formatter.step({
  "name": "user is present in PolicyCenter",
  "keyword": "Given "
});
formatter.match({
  "location": "PCStepDefinition.userInPC()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on logout",
  "keyword": "When "
});
formatter.match({
  "location": "PCStepDefinition.pcLogout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is logged out of CC successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "PCStepDefinition.logoutSuccessfully()"
});
formatter.result({
  "status": "passed"
});
});