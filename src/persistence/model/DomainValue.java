/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Chris Whiteley
 */
@MappedSuperclass
public class DomainValue extends Audit implements Comparable<DomainValue> {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String name = "";
    private String description;
    private long sortOrder;

    public boolean isNull() {
        return ((id == 0L) && (name.length() == 0));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof DomainValue)) {
            return false;
        }

        DomainValue other = (DomainValue) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }

    /**
     * @return the Id
     */
    public long getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the sortOrder
     */
    public long getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder the sortOrder to set
     */
    public void setSortOrder(long sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     *
     * @return the string to display
     */
    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(DomainValue that) {
        long result = this.sortOrder - that.sortOrder;
        if (result < 0L) {
            return -1;
        } else if (result == 0L) {
            return 0;
        } else {
            return 1;
        }
    }

    public static class Domains {

        public static final String ACQUISITIONTYPE = "100255"; //FI - Acquisition Type
        public static final String ADAGREEMENTTYPELKP = "28"; //AD - Agreement Type
        public static final String ADASSETTYPE = "38"; //Assets Type
        public static final String ADBUDGET = "221"; //AD - Budget
        public static final String ADCAPACITYTYPE = "8"; //AD - Capacity Type
        public static final String ADCARRIERFEC = "64"; //SA - Satellite carrier FEC
        public static final String ADCARRIERMODULATION = "63"; //SA - Satellite carrier modulation
        public static final String ADCARRIERPRIMARYUSE = "65"; //SA - Satellite carrier primary use
        public static final String ADCARRIERTYPE = "62"; //SA - Satellite carrier Type
        public static final String ADCONNECTIVITY = "100013"; //AD - Connectivity
        public static final String ADDURATIONTYPE = "31"; //AD - Financial Duration Type
        public static final String ADEQUIPAGRNOTES = "208"; //ADEQUIPAGREEMENT notes domain
        public static final String ADFINANCETYPE = "12"; //AD - Finance Type
        public static final String ADINVOICEDOCUMENTS = "100008"; //Invoice documents domain
        public static final String ADINVOICENOTES = "205"; //Invoice notes
        public static final String ADLEACHAGRDOCUMENTS = "220"; //ADLEASE Agreement documents domain
        public static final String ADLEASE2PROJCODELKP = "100226"; //FI - Project (on Lease Maintenance Screen)
        public static final String ADLEASECONTRACTTYPE = "5"; //AD - Purchase Lease Contract Types
        public static final String ADLEASENOTES = "76"; //ADLEASE table notes domian identifier
        public static final String ADLEASESERVICETYPE = "39"; //FI - Lease Contract Types
        public static final String ADLEASETYPE = "4"; //FP - Lease purchase type
        public static final String ADLEDGERANALYSISCODE = "6"; //AD - Ledger Analysis Code
        public static final String ADLEDGERCIRCUITOWNERTYPE = "30"; //AD - Ledger Circuit Owner Type
        public static final String ADLEDGERSTATE = "225"; //Ledger State
        public static final String ADLEDGERTRANSACTIONSTATUS = "10"; //AD - Ledger Transactions Status
        public static final String ADLEDGERTRANSTYPE = "151"; //Ledger Transaction Types
        public static final String ADOBPERCENTAGE = "69"; //AD - Lease Onward bill percentage values
        public static final String ADOMF100NOTES = "279"; //ADOMF100 Notes domain
        public static final String ADOMF101NOTES = "280"; //ADOMF101 Notes domain
        public static final String ADOMF103NOTES = "278"; //ADOMF103 Notes domain
        public static final String ADOMFCONTRACTNOTES = "100149"; //ADOMFContract Notes domain
        public static final String ADOMFCOSTRECOVERYNOTES = "100157"; //ADOMFCostRecovery Notes domain
        public static final String ADOMRECOVERYEMAILTO = "100224"; //OM - CR Invoice Email to
        public static final String ADOMRECOVERYSUBJECT = "100225"; //OM - CR Invoice Subject
        public static final String ADOPEXCOS = "101"; //AD - OPEX COS type
        public static final String ADPAYFREQUENCY = "33"; //FI - Payment Frequency
        public static final String ADPAYTERMS = "100036"; //AD - Payment Terms
        public static final String ADPURCHAGRDOCUMENTS = "218"; //ADPURCHASE Agreements documents domain
        public static final String ADPURCHAGRNOTES = "80"; //ADPURCHASEAGREEMENT notes domain
        public static final String ADPURCHASETYPE = "7"; //AD - Capacity Purchase Types
        public static final String ADRECUREVENT = "58"; //SA - Satellite outv recuring event
        public static final String ADREF104DOCS = "260"; //ADREF104 Documents domain
        public static final String ADREF104NOTES = "259"; //ADREF104 notes domain
        public static final String ADRESTANNUALCOSTS = "141"; //RE - Restoration annual charge types
        public static final String ADRESTANNUALRECEIPTS = "143"; //RE - Restoration annual receipt types
        public static final String ADRESTBUSINESSUNIT = "268"; //RE - Restoration C&W Business Units
        public static final String ADRESTCOSTRECEIPT = "150"; //AD - Cost or Receipt type
        public static final String ADRESTCOSTTYPE = "297"; //RE - Restoration costs Cost types
        public static final String ADRESTDAILYCOSTS = "140"; //RE - Restoration daily cost types
        public static final String ADRESTDAILYRECEIPTS = "142"; //RE - Restoration daily receipt types
        public static final String ADRESTDAYANNUAL = "145"; //AD - Daily or annual charge type
        public static final String ADRESTFULLYEAR = "100005"; //RE - Restoration Full Years
        public static final String ADRESTINSURANCESTATUS = "146"; //RE - Restoration insurance claim status
        public static final String ADRESTOBTYPE = "100006"; //RE - Restoration Onward Bill Types
        public static final String ADRESTORATIONREGION = "139"; //RE - Restoration Regions
        public static final String ADRESTPAYSTATUS = "100035"; //AD - PAYSTATUS
        public static final String ADRESTRECORDTYPE = "261"; //AD - Record type for ADRESTORATION table
        public static final String ADRESTSTATUS = "144"; //RE - Restoration status types
        public static final String ADRESTYEAR = "298"; //RE - Restoration years
        public static final String ADRESTYESNO = "258"; //AD - Yes or No
        public static final String ADSALCHAGRDOCUMENTS = "219"; //ADSALES Agreements documents domain
        public static final String ADSALEAGRNOTES = "81"; //ADSALEAGREEMENT notes Domain
        public static final String ADSALETYPE = "13"; //AD - Sale Agreement Types
        public static final String ADSATAGREEMENTDOCUMENTS = "102"; //Satellite Agreement Documents
        public static final String ADSATAGREEMENTNOTES = "215"; //ADSATAGREEMENT Notes domain
        public static final String ADSATCAPACITYRATES = "53"; //SA - Satellite capacity rates
        public static final String ADSATCARRIERNOTES = "103"; //ADSATCARRIER notes domian
        public static final String ADSATELLITESUPPLIER = "100012"; //SA - Satellite Supplier
        public static final String ADSATFARENDANTENNA = "100021"; //AD - Far End Antenna Details
        public static final String ADSATFYDISCOUNT = "54"; //SA - Satellite first year discount
        public static final String ADSATINITIALSPONSOR = "51"; //SA - Satellite initial sponsor
        public static final String ADSATLEASEPRIMARYUSE = "67"; //SA - Satellite lease primary use
        public static final String ADSATLEASESERVSTATUS = "66"; //Satellite lease service status
        public static final String ADSATLEASESTATUS = "55"; //SA - Satellite lease status
        public static final String ADSATORBITALLOCATION = "100017"; //SA - Satellite Orbital location
        public static final String ADSATPERIOD = "212"; //SA - Satellite LTC Period
        public static final String ADSATPREEMPT = "52"; //SA - Satellite pre-emptibility
        public static final String ADSATPRIMARYUSE = "56"; //SA - Satellite primary use
        public static final String ADSATRENEWOPTIONS = "49"; //SA - Satellite renewable options
        public static final String ADSATSERVICETYPE = "50"; //SA - Satellite service types
        public static final String ADSTARTMONTH = "34"; //AD - Contract Start Months
        public static final String ADTDMACONFIG = "60"; //SA - Satellite TDMA configuration
        public static final String ADTDMAROLLING = "61"; //Satellite TDMA rolling commitment
        public static final String ADTDMATYPE = "59"; //SA - Satellite TDMA type
        public static final String ADTRANSREC = "57"; //SA - Satellite transmit receive
        public static final String AGREEMENTORDER = "29"; //Order of rows returned from agreement search
        public static final String AGREEMENTSTATUS = "9"; //TR - Agreement Status values
        public static final String APPORTIONEDMETHOD = "100069"; //AD - Apportioned Method
        public static final String APPROVAL_STATUS = "100252"; //AD - Cable Investment: Approval Status
        public static final String APTITLETXT = "100229"; //AD - AP Forms of address (Dear AP)
        public static final String ADDITIONAL_COST_GL_CODE = "100072"; //AD - GL Code for additional costs
        public static final String BATCHNOTES = "100027"; //Batch Notes
        public static final String BATCHTYPE = "100045"; //WL - Batch Types
        public static final String CABLEDETAILS = "47"; //Cable System Detail Notes
        public static final String CABLESYSTEMS_ACCESS_COUNTRIES = "100246"; //AD - Cable System: Access Countries
        public static final String CABLESYSTEMS_ACTIVATION_UNIT = "100245"; //AD - Cable System: Activation Unit
        public static final String CABLESYSTEMS_COMMERCIALMODEL = "100239"; //AD - Cable System: Commercial Model
        public static final String CABLESYSTEMS_MIU = "100244"; //AD - Cable System: MIU
        public static final String CABLESYSTEMS_NODE_TYPE = "100247"; //AD - Cable System: Node Type
        public static final String CABLESYSTEMS_OWNER = "100241"; //AD - Cable System: Owner
        public static final String CABLESYSTEMS_REGION = "100242"; //AD - Cable System: Region
        public static final String CABLESYSTEMS_STATUS = "100243"; //AD - Cable System: Status
        public static final String CABLESYSTEMS_TRANSMISSIONPATH = "100240"; //AD - Cable System: Transmission Path
        public static final String CABLE_INVESTMENT_DOCUMENTS = "100259"; //Cable Investment Documents Domain
        public static final String CABLE_INVESTMENT_NOTES = "100260"; //Cable Investment Notes Domain
        public static final String CABLE_SYSTEM_DOCUMENTS = "100248"; //Cable System Documents Domain
        public static final String CABLE_SYSTEM_NOTES = "100249"; //Cable System Notes Domain
        public static final String CAPACITYNOTES = "48"; //Notes attached to a capacity 
        public static final String CAPACITY_ALLOCATION = "100258"; //AD - Cable Investment: Capacity Allocation
        public static final String COMPLETION_DATE_STATUS = "100253"; //AD - Cable Investment: Completion Date Status
        public static final String CONTACTTYPES = "227"; //Contact Types (NOT USED)
        public static final String CWCBUSINESSUNIT = "11"; //C&W International Business Units. (NOT USED)
        public static final String CW_PLAN_REGION = "14"; //FA - CW Plan region (May get moved to Dimension)
        public static final String CW_PLAN_REGION_SAT = "257"; //SA - C&W Planning Regions for Satellite
        public static final String DIMSTARTENDNODE = "100042"; //DimStartEndNode
        public static final String EQUIPMENTAGREEMENT = "207"; //Manage Equipment Purchase Agreements notes
        public static final String EQUIPMENTAGREEMENTSTATUS = "201"; //TR - Equipment Agreement Status
        public static final String FAAPPLICATIONINFO = "100007"; //FA - Falcon Application Info
        public static final String FABANDWIDTHSOURCE = "217"; //Bandwidth Source
        public static final String FINLEDGERCODECAT = "100034"; //Financial Ledger Code Category
        public static final String FPBATCHDATERANGE = "100044"; //FP - Batch View Date Range
        public static final String FPBATCHVIEWTYPE = "100043"; //FP - Batch View Types
        public static final String FPBILATERALFORECASTNOTES = "216"; //FPBILATERALFORECAST NOTES DOMAIN
        public static final String FPBILATERALSOURCE = "24"; //FP - Bilateral Source
        public static final String FPCOSTCENTRE = "152"; //Cost Centre
        public static final String FPCUSTOMER = "18"; //FP - Customer
        public static final String FPDCMEEQUIPMENT = "100009"; //FP - DCME Equipment
        public static final String FPDCMELOCATION = "100011"; //FP - DCME Locations
        public static final String FPDCMEQRY = "224"; //FP - DCME Query Criteria
        public static final String FPDCMESTATUS = "100010"; //FP - DCME Status
        public static final String FPDEFAULTCOSTCENTRE = "100001"; //FP - Default cost centre
        public static final String FPDEFAULTCOSTSTATUS = "100000"; //FP - Default cost status
        public static final String FPDEMANDSTATUS = "22"; //FP - Demand Status
        public static final String FPINCDECFACTOR = "98"; //FP - Increase/Decrease Factor for DCME gain
        public static final String FPJOBROLE = "46"; //FP - Job Role
        public static final String FPMINTYPE = "25"; //FP - Minute Type
        public static final String FPOWNEDIRU = "87"; //Owned/IRU
        public static final String FPOWNERTYPE = "85"; //FP - Owner Type
        public static final String FPPLANNINGYEAR = "26"; //FP - Planning Year
        public static final String FPPROGRAMME = "32"; //FP - Programme
        public static final String FPQUARTER = "27"; //Quarter
        public static final String FPREACH = "210"; //FP - Reach
        public static final String FPRESTORATION = "222"; //FP - Restoration
        public static final String FPROUTEDOCUMENTS = "100033"; //Route Documents
        public static final String FPROUTESTATUS = "40"; //Route Status
        public static final String FPSATREGION = "88"; //FP - Satellite Region
        public static final String FPSEGMENTTYPE = "75"; //FP - Segment Type
        public static final String FPSHORTFALLTYPE = "89"; //FP - Shortfall Type
        public static final String FPSTATUSCOMMENTPROGRAMME = "154"; //FP - Programme - Status Comments 
        public static final String FPSTATUSCOMMNOTES = "213"; //FP Status Comments Notes
        public static final String FPSTRATEGYNOTES = "214"; //FP Strategy Comments Notes
        public static final String FPSUPPLYOPTION = "37"; //FP - Forecast & Planning Supply Option
        public static final String FPTOTALTYPE = "97"; //FP - Total Type
        public static final String FPTRANPLANNOTES = "256"; //Notes for transmission planning
        public static final String FPTRANSDEFAULTCURRENCY = "100003"; //FP - Default Currency for Transmission
        public static final String HOLDING_TYPE = "100250"; //AD - Cable Investment: Holding Type
        public static final String ICPNOTES = "291"; //notes for worklist ipl screen, ICP NOTES
        public static final String ICPSTATUS = "100129"; //WL - ICP Status
        public static final String ICPYESNO = "100137"; //ICP - Yes or No
        public static final String INVESTMENT_UNIT = "100257"; //AD - Cable Investment: Investment Unit
        public static final String INVOICEEMAILPLANNERSUBJECT = "100214"; //AD - Invoice Email Planner Subject
        public static final String INVOICEEMAILPLANNERTO = "100171"; //AD - Invoice Email Planner To
        public static final String INVOICEEMAILSUBJECT = "100172"; //AD - Invoice Email Subject
        public static final String INVOICEEMAILTO = "100173"; //AD - Invoice Email to
        public static final String INVOICEEMAILTOASIA = "100183"; //AD - Invoice Email to (Asia)
        public static final String INVOICEEMAILTOINDIA = "100185"; //AD - Invoice Email to (India)
        public static final String INVOICEEMAILTOOM = "100184"; //AD - Invoice Email to (O and M)
        public static final String INVOICETYPE = "155"; //Invoice Types
        public static final String IPLCCARRIERDOCNOTES = "100134"; //IPLC Carrier document notes
        public static final String IPLDMONOTES = "292"; //Notes for worklist ipl screen, IPL DMO NOTES
        public static final String IPLTRANSNOTES = "290"; //Notes for worklist ipl screen, IPL NOTES
        public static final String ISSUESPROJECTID = "100064"; //IS - Issues Project ids
        public static final String ISSUESSTATUS = "100065"; //IS - Issues status
        public static final String ISSUESURGENCY = "100063"; //IS - Issues Urgency
        public static final String ISSUESVERSION = "100068"; //IS - Issues Release Version
        public static final String LEASEAGREEMENTDOC = "100175"; //LBSD
        public static final String LEASEAUTOEMAILTO = "100227"; //FI - LBED Change notification email to
        public static final String LEASEBILLENDRECDOC = "100181"; //Lease Billing End Date Received/Confirmed
        public static final String LEASEBILLENDREQDOC = "100180"; //Lease Billing End Date Requested
        public static final String LEASEBUSCASEDOC = "100177"; //Business Case
        public static final String LEASECOSTDOC = "100174"; //Correspondence
        public static final String LEASEMETCESSRECDOC = "100179"; //Network Cessation Received/Confirmed
        public static final String LEASENETCESSREQDOC = "100178"; //Network Cessation Requested
        public static final String LEASEORDERDOC = "100176"; //Order/Agreement
        public static final String LEDGER_CAPACITY_UNIT = "3"; //AD - Capacity units incl MIUs
        public static final String LOCATION_REGION = "100261"; //Location Regions
        public static final String MAILSERVER = "262"; //FP - Name of mail server
        public static final String OANDMCONTRACTTYPES = "265"; //OM - Contract types for O&M
        public static final String OMCONTRACTDOCUMENTS = "100041"; //OM Contract Documents
        public static final String OMCOSTRECOVERYDOCUMENTS = "100158"; //OM CostRecovery Documents
        public static final String OMDEFAULTVALUES = "100025"; //OM Default Values
        public static final String OMRECOVERIESDOCUMENTS = "100154"; //OM Recovery Documents
        public static final String OMRECOVERIESDOCUMENTS2 = "100155"; //OM Recovery Documents
        public static final String OMRECOVERYTYPE = "100156"; //O&M Recovery Type
        public static final String ONWARDBILLINGCONTACTS = "226"; //FA - C&W Invoice Payment contact details
        public static final String ONWARDBILLINGTYPE = "223"; //AD - Onward billing invoice type
        public static final String OSSCARRIERDOCNOTES = "100135"; //OSS Carrier document notes
        public static final String PERCENTAGEDETAILS = "96"; //Cable System Percentage Ownership Details screens note panel
        public static final String POCATEGORY = "100219"; //PO - Categories
        public static final String POREQUESTOR = "100218"; //PO - Requestor names
        public static final String POSTATUS = "100073"; //FI - PO Status
        public static final String PRODUCTION = "100066"; //IS - Production URL
        public static final String PURCHASEORDERSWITCH = "100070"; //Switch to enable/disable purchase order checking
        public static final String PURORDERDOCUMENTS = "100114"; //Purchase Order Documents
        public static final String RECONCILIATIONEMAILDEAR = "100217"; //AD - Reconciliation Complete Email Dear
        public static final String RECONCILIATIONEMAILTO = "100216"; //AD - Reconciliation Complete Email To
        public static final String RECONCILIATIONSUBJECT = "100215"; //AD - Reconciliation Complete Email Subject
        public static final String RENEWALREVIEWPERIOD = "100182"; //FI - Review period for contract renewals
        public static final String RESTCOSTS = "264"; //Manage Restoration costs notes
        public static final String RESTONWARDBILL = "263"; //Manage Restoration Onward Bills notes
        public static final String ROUTENOTES = "99"; //FP route Notes Domain
        public static final String SAPVOUCHERDESCRIPTION = "100228"; //FI - SAP Voucher Description text
        public static final String SATLEASESERVICENOTES = "100015"; //Notes for a Satellite lease service
        public static final String SATSEGDOCS = "100020"; //Documents for Satellite segment
        public static final String SATSEGNOTES = "100019"; //Notes for Satellite segment
        public static final String SLACARRIERDOCNOTES = "100136"; //SLA Carrier document notes
        public static final String SPAHUMAKER = "43"; //SP - AHU Maker
        public static final String SPAHUNOTES = "84"; //SPAireHandlingUnit notes
        public static final String SPAHUTYPE = "44"; //SP - AHU Type
        public static final String SPALIENATIONPROVISION = "100039"; //SP - Alienation Provision
        public static final String SPBATTERYMAKER = "90"; //SP - Battery Manufacturer
        public static final String SPBREAKYESNOROLLING = "312"; //SP - Break Clause in contract
        public static final String SPBUILDINGCONSTTYPE = "100231"; //SP - Building Construction Type
        public static final String SPCHILLERPROVISION = "42"; //SP - Chiller Provision
        public static final String SPCONFIGURATION = "21"; //SP - Configuration (N, N+1)
        public static final String SPCONTRACTDOCUMENTS = "311"; //SP - Contract Documents
        public static final String SPCONTRACTDURATIONTYPE = "309"; //SP - Contract Duration Type
        public static final String SPCONTRACTFORMAT = "304"; //SP - Contract Format
        public static final String SPCONTRACTNOTES = "310"; //SP - Contract Notes
        public static final String SPCONTRACTPURPOSE = "305"; //SP - Contract Purpose
        public static final String SPCONTRACTSTATUS = "302"; //SP - Contract Status
        public static final String SPCONTRACTSUPPLIER = "308"; //SP - Contract Supplier Name
        public static final String SPCONTRACTTYPE = "303"; //SP - Contract Type
        public static final String SPCOOLINGPLANTMAKER = "156"; //SP - Cooling Plant Maker
        public static final String SPCOOLINGPLANTTYPE = "157"; //SP - Cooling Plant Type
        public static final String SPDCSELECTION = "286"; //SP - DC Selection
        public static final String SPEQAREAFLOORTYPE = "36"; //SP - Floor Type
        public static final String SPEQAREAFUNCTION = "2"; //SP - Equipment area function
        public static final String SPEQAREAIPC = "100237"; //SP - Infrastructure Planning Classification (Eq. Area)
        public static final String SPEQAREANOTES = "83"; //SPEquipment Area Notes
        public static final String SPFREQUENCY = "100040"; //SP - Payment Frequency
        public static final String SPFUELTANKLOCATION = "100235"; //SP - Fuel Tank Locations
        public static final String SPFUELTANKNOTES = "199"; //SP Fuel Tank Notes
        public static final String SPGENERATORLOCATION = "100233"; //SP - Generator Locations
        public static final String SPGENERATORPHASES = "100234"; //SP - Generator Phases
        public static final String SPGENERICEQTYPE = "92"; //SP - Generic Equipment Type
        public static final String SPGENERICFUELCONS = "100236"; //SP - Generic Fuel Consumption
        public static final String SPGENMAKER = "94"; //SP - Generator Maker
        public static final String SPGENNOTES = "200"; //SP Generator Notes
        public static final String SPGENTYPE = "95"; //SP - Generator Type
        public static final String SPINFPLANNCLASS = "100230"; //SP - Infrastructure Planning Classification
        public static final String SPLANDLORD = "211"; //SP - Site Landlord
        public static final String SPMAINSDISTBOARD = "45"; //SP - Mains Dist Board
        public static final String SPMAINSSELECTION = "285"; //SP - Mains Selection
        public static final String SPMAINSSUPPLYCO = "20"; //SP - Mains Supply Company
        public static final String SPMAINSSUPPLYNOTES = "149"; //SPMAINSSUPPLY notes domain
        public static final String SPMISCLOADTYPE = "206"; //SP - Misc Load Type
        public static final String SPOWNINGORG = "100238"; //SP - Owning Organisation
        public static final String SPPAYMENTFREQ = "306"; //SP - Contract Payment Frequency
        public static final String SPPOWERDEMANDDETAILNOTES = "296"; //SPPOWERDEMANDDETAILNOTES notes
        public static final String SPPOWERFEED = "100"; //SP - Space Utilisation Power Feed
        public static final String SPPROVENANCE = "100232"; //SP - Site Provenance
        public static final String SPQUANTITYUNITS = "288"; //SP - Allocation Request Detail Quantity Units
        public static final String SPRACK = "299"; //SP - Power Demand Detail Rack
        public static final String SPRECTIFIERDISTBOARDNOTES = "148"; //SPRECTIFIERDISTBOARD notes domain
        public static final String SPRECTIFIERMAKER = "91"; //SP - Rectifier Manaufacturer
        public static final String SPRECTIFIERNOTES = "147"; //SPRECTIFIER notes domain
        public static final String SPRECTIFIERTYPE = "93"; //SP - Rectifier Type
        public static final String SPREQUESTDETAILPLATFORM = "289"; //SP - Allocation Request Detail Platform
        public static final String SPREQUESTDETAILTYPE = "287"; //SP - Allocation Request Detail Type
        public static final String SPREQUESTTYPE = "104"; //SP - Allocation Request Type
        public static final String SPSITEFIRETYPE = "16"; //SP - Site Fire Type
        public static final String SPSITENETPOSITION = "277"; //SP - Site Network Position in Heirarchy
        public static final String SPSITENOTES = "153"; //SP Site Notes
        public static final String SPSITESTATUS = "15"; //SP - Site Status
        public static final String SPSITETENURE = "17"; //SP - Site Tenure
        public static final String SPSITETYPE = "1"; //SP - Site type
        public static final String SPSPACETYPE = "105"; //SP - Space Type
        public static final String SPSPACEUTILPASSIVE = "283"; //SP - Space Utilisation Active/Passive
        public static final String SPSPACEUTILSTATUS = "23"; //SP - Space Utilisation Status
        public static final String SPSTARTMONTH = "307"; //SP - Contract Payment Start Month
        public static final String SPSUITELINEGENERICROLE = "209"; //SP - Suite Line Generic Role
        public static final String SPSUPPLYCO = "72"; //SP - Supply Company
        public static final String SPSUPPLYPHASE = "71"; //SP - Supply Phase
        public static final String SPSUPPLYVOLTAGE = "68"; //SP - Supply Voltage
        public static final String SPTRANSFORMERCONFIG = "74"; //SP - Transformer Configuration
        public static final String SPTRANSFORMEROWNER = "73"; //SP - Transformer Owner
        public static final String SPTRANSFORMERTYPE = "70"; //SP - Transformer Type
        public static final String SPUPSDISTBOARDNOTES = "282"; //UPS DISTRIBUTION BOARD NOTES
        public static final String SPUPSMAKER = "77"; //SP - UPS Maker
        public static final String SPUPSNOTES = "79"; //UPS Notes
        public static final String SPUPSSELECTION = "284"; //SP - USP Selection
        public static final String SPUPSSYSTEMTYPE = "78"; //SP - UPS Type
        public static final String TAGPREFIX = "100004"; //AD - AD O&M Tag Ref prefix letter
        public static final String TEST = "100067"; //IS - Test URL
        public static final String TOPOLOGYTREENOTES = "86"; //TOPOLOGY TREE notes
        public static final String TRANSACTION_TYPE = "100251"; //AD - Cable Investment: Transaction Type
        public static final String TRANS_CAPACITY_TYPE = "100256"; //AD - Cable Investment: Transaction Capacity Type
        public static final String TYPEBDERIVATIVE = "100194"; //Type Derivatives
        public static final String USERDEPARTMENT = "228"; //FP - C&W Business Units
        public static final String VODAFONE_ENTITY = "100254"; //AD - Cable Investment: Vodafone Entity
        public static final String WLC20NOTES = "100100"; //WLC20 Note
        public static final String WLC20REPCAT = "100101"; //WLC20 Report Category
        public static final String WLC20STATUS = "272"; //WL - C20 Status
        public static final String WLCHANNELISATION = "100127"; //WL - Channelisation
        public static final String WLCLLI = "100123"; //WL - CLLI
        public static final String WLCWISC = "100125"; //WL - CW ISC
        public static final String WLDEFAULTPROJECT = "100002"; //WL - Default Project
        public static final String WLDIRECTION = "269"; //WL - CCT Direction
        public static final String WLDMOICOINSQ = "100094"; //WL - Icoins Queues
        public static final String WLDMONOTES = "100095"; //Work List DMO Notes
        public static final String WLDMOREPCAT = "100096"; //WLDMO Report Category
        public static final String WLDMOREPORT = "300"; //WL - DMO report output
        public static final String WLDMOSTATUS = "100097"; //WL - DMO Status
        public static final String WLFARENDCLLI = "100124"; //WL - FAR END CLLI
        public static final String WLFARENDISC = "100126"; //WL - FAR END ISC
        public static final String WLIDTC = "301"; //Worklist IDTC values
        public static final String WLMANAGER = "100220"; //WL - Manager for copy emails
        public static final String WLNEXTACTIONBY = "266"; //Next Group to action a Worklist item
        public static final String WLNOTES = "281"; //Work Item Note
        public static final String WLORDERTYPE = "274"; //WL - Order Type
        public static final String WLORDERTYPE2 = "100099"; //WL - Order Type
        public static final String WLPROGRAMME = "270"; //WL - Programme
        public static final String WLSERVICETYPE = "267"; //Service Type
        public static final String WLSIGNALTYPE = "271"; //WL - Signal Type
        public static final String WLSTATUS = "276"; //WL - Status
        public static final String WLSWITCHTYPE = "100098"; //WL - Switch Types
        public static final String WLTC10PRIORITY = "273"; //TC10 Priority
        public static final String YN = "294"; //FA - Yes No YN    
    }
}
