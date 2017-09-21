package crypto.model.getCoinSnapshotByFullID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/23/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class General {

    String id; //: "7605",
    String documentType; //: "Webpagecoinp",
    String h1Text; //: "Ethereum (ETH)",
    String dangerTop; //: "",
    String warningTop; //: "",
    String infoTop; //: "",
    String symbol; //: "ETH",
    String url; //: "/coins/eth/",
    String baseAngularUrl; //: "/coins/eth/",
    String name; //: "Ethereum ",
    String imageUrl; //: "/media/20646/eth.png",
    String description; //: "<p>Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third party interference. In the Ethereum protocol and blockchain there is a price for each operation. The general idea is, in order to have things transferred or executed by the network, you have to <a href="/coins/guides/what-is-the-gas-in-ethereum/" target="_blank">consume or burn Gas</a>. The cryptocurrency is called Ether and is used to pay for computation time and for transaction fees.</p><p>If you want to earn block rewards from the network, you can join the network as a miner. Follow the link for a <a href="/mining/guides/how-to-mine-ethereum/" target="_blank">guide on how to mine Ethereum on a Windows Pc</a>. The much easier but a bit more expensive way is to <a href="/mining/guides/how-to-mine-ethereum-the-easy-way-an-ethereum-mining-contract/" target="_blank">buy an Ethereum mining contract</a>. </p><p>Ethereum is how the Internet was supposed to work. As long as you have enough funds to pay for your code to be run by the network, your contacts will always be up and running.</p><p>It was crowdfunded during August 2014 by fans all around the world. It is developed and maintained by ETHDEV with contributions from great minds across the globe. There is also an Ethereum foundation and there are multiple startups working with the Ethereum blockchain.</p><p>Ethereum is currently on the "Homestead" stage and all its related software is still considered Beta until the release of the next stage "Metropolis". </p><p>If you are looking for a GUI interface for your wallet, try the <a href="/wallets/ethereum-wallet-dapp/" target="_blank">Ethereum Wallet DApp</a>. It&#39;s still in beta so be careful when you use it.</p><p>Our block explorer data bellow is freely provided by <a href="https://etherchain.org/" target="_blank">etherchain.org</a> and <a href="http://etherscan.io/" target="_blank">etherscan.io</a>. </p>",
    String features; //: "<p>Ethereum is a platform that is intended to allow people to easily write decentralized applications (Đapps) using blockchain technology. A decentralized application is an application which serves some specific purpose to its users, but which has the important property that the application itself does not depend on any specific party existing. Rather than serving as a front-end for selling or providing a specific party&#39;s services, a Đapp is a tool for people and organizations on different sides of an interaction use to come together without any centralized intermediary.</p><p>Contracts generally serve four purposes:</p><p>- Maintain a data store representing something which is useful to either other contracts or to the outside world; one example of this is a contract that simulates a currency, and another is a contract that records membership in a particular organization.</p><p>- Serve as a sort of externally owned account with a more complicated access policy; this is called a "forwarding contract" and typically involves simply resending incoming messages to some desired destination only if certain conditions are met; for example, one can have a forwarding contract that waits until two out of a given three private keys have confirmed a particular message before resending it (ie. multisig). More complex forwarding contracts have different conditions based on the nature of the message sent; the simplest use case for this functionality is a withdrawal limit that is overrideable via some more complicated access procedure.</p><p>- Manage an ongoing contract or relationship between multiple users. Examples of this include a financial contract, an escrow with some particular set of mediators, or some kind of insurance. One can also have an open contract that one party leaves open for any other party to engage with at any time; one example of this is a contract that automatically pays a bounty to whoever submits a valid solution to some mathematical problem, or proves that it is providing some computational resource.</p><p>- Provide functions to other contracts; essentially serving as a software library.</p><p>Contracts interact with each other through an activity that is alternately called either "calling" or "sending messages". A "message" is an object containing some quantity of ether (a special internal currency used in Ethereum with the primary purpose of paying transaction fees), a byte-array of data of any size, the addresses of a sender and a recipient. When a contract receives a message it has the option of returning some data, which the original sender of the message can then immediately use. In this way, sending a message is exactly like calling a function.</p>",
    String technology; //: "<p><strong>Sandwich complexity model</strong>: the bottom level architecture of Ethereum should be as simple as possible, and the interfaces to Ethereum (including high level programming languages for developers and the user interface for users) should be as easy to understand as possible. Where complexity is inevitable, it should be pushed into the "middle layers" of the protocol, that are not part of the core consensus but are also not seen by end users - high-level-language compilers, argument serialization and deserialization scripts, storage data structure models, the leveldb storage interface and the wire protocol, etc. However, this preference is not absolute.</p><p><strong>Freedom</strong>: users should not be restricted in what they use the Ethereum protocol for, and we should not attempt to preferentially favor or disfavor certain kinds of Ethereum contracts or transactions based on the nature of their purpose. This is similar to the guiding principle behind the concept of "net neutrality". One example of this principle not being followed is the situation in the Bitcoin transaction protocol where use of the blockchain for "off-label" purposes (eg. data storage, meta-protocols) is discouraged, and in some cases explicit quasi-protocol changes (eg. OP_RETURN restriction to 40 bytes) are made to attempt to attack applications using the blockchain in "unauthorized" ways. In Ethereum, we instead strongly favor the approach of setting up transaction fees in such a way as to be roughly incentive-compatible, such that users that use the blockchain in bloat-producing ways internalize the cost of their activities (ie. Pigovian taxation).</p><p><strong>Generalization:</strong> protocol features and opcodes in Ethereum should embody maximally low-level concepts, so that they can be combined in arbitrary ways including ways that may not seem useful today but which may become useful later, and so that a bundle of low-level concepts can be made more efficient by stripping out some of its functionality when it is not necessary. An example of this principle being followed is our choice of a LOG opcode as a way of feeding information to (particularly light client) dapps, as opposed to simply logging all transactions and messages as was internally suggested earlier - the concept of "message" is really the agglomeration of multiple concepts, including "function call" and "event interesting to outside watchers", and it is worth separating the two.</p><p><strong>Have No Features</strong>: as a corollary to generalization, the dev team often refuses to build in even very common high-level use cases as intrinsic parts of the protocol, with the understanding that if people really want to do it they can always create a sub-protocol (eg. ether-backed subcurrency, bitcoin/litecoin/dogecoin sidechain, etc) inside of a contract. An example of this is the lack of a Bitcoin-like "locktime" feature in Ethereum, as such a feature can be simulated via a protocol where users send "signed data packets" and those data packets can be fed into a specialized contract that processes them and performs some corresponding function if the data packet is in some contract-specific sense valid.</p><p><strong>Non-risk-aversion</strong>: the dev team is okay with higher degrees of risk if a risk-increasing change provides very substantial benefits (eg. generalized state transitions, 50x faster block times, consensus efficiency, etc)</p>",
    String totalCoinSupply; //: "0",
    String algorithm; //: "Ethash",
    String proofType; //: "PoW",
    String startDate; //: "30/07/2015",
    String twitter; //: "@ethereumproject",
    String affiliateUrl; //: "https://www.ethereum.org/",
    String website; //: "<a href='https://www.ethereum.org/' target='_blank'>Ethereum </a>",
    Sponsor sponsor; //: {},
    int lastBlockExplorerUpdateTS; //: 1503486869,
    String difficultyAdjustment; //: "Per 1 Block",
    String blockRewardReduction; //: "",
    int blockNumber; //: 4194046,
    int blockTime; //: 19,
    double netHashesPerSecond; //: 94023954748818.34,
    double totalCoinsMined; //: 94191288.78029999,
    int previousTotalCoinsMined; //: 0,
    int blockReward; //: 5

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getH1Text() {
        return h1Text;
    }

    public void setH1Text(String h1Text) {
        this.h1Text = h1Text;
    }

    public String getDangerTop() {
        return dangerTop;
    }

    public void setDangerTop(String dangerTop) {
        this.dangerTop = dangerTop;
    }

    public String getWarningTop() {
        return warningTop;
    }

    public void setWarningTop(String warningTop) {
        this.warningTop = warningTop;
    }

    public String getInfoTop() {
        return infoTop;
    }

    public void setInfoTop(String infoTop) {
        this.infoTop = infoTop;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBaseAngularUrl() {
        return baseAngularUrl;
    }

    public void setBaseAngularUrl(String baseAngularUrl) {
        this.baseAngularUrl = baseAngularUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getTotalCoinSupply() {
        return totalCoinSupply;
    }

    public void setTotalCoinSupply(String totalCoinSupply) {
        this.totalCoinSupply = totalCoinSupply;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getAffiliateUrl() {
        return affiliateUrl;
    }

    public void setAffiliateUrl(String affiliateUrl) {
        this.affiliateUrl = affiliateUrl;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public int getLastBlockExplorerUpdateTS() {
        return lastBlockExplorerUpdateTS;
    }

    public void setLastBlockExplorerUpdateTS(int lastBlockExplorerUpdateTS) {
        this.lastBlockExplorerUpdateTS = lastBlockExplorerUpdateTS;
    }

    public String getDifficultyAdjustment() {
        return difficultyAdjustment;
    }

    public void setDifficultyAdjustment(String difficultyAdjustment) {
        this.difficultyAdjustment = difficultyAdjustment;
    }

    public String getBlockRewardReduction() {
        return blockRewardReduction;
    }

    public void setBlockRewardReduction(String blockRewardReduction) {
        this.blockRewardReduction = blockRewardReduction;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public int getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(int blockTime) {
        this.blockTime = blockTime;
    }

    public double getNetHashesPerSecond() {
        return netHashesPerSecond;
    }

    public void setNetHashesPerSecond(double netHashesPerSecond) {
        this.netHashesPerSecond = netHashesPerSecond;
    }

    public double getTotalCoinsMined() {
        return totalCoinsMined;
    }

    public void setTotalCoinsMined(double totalCoinsMined) {
        this.totalCoinsMined = totalCoinsMined;
    }

    public int getPreviousTotalCoinsMined() {
        return previousTotalCoinsMined;
    }

    public void setPreviousTotalCoinsMined(int previousTotalCoinsMined) {
        this.previousTotalCoinsMined = previousTotalCoinsMined;
    }

    public int getBlockReward() {
        return blockReward;
    }

    public void setBlockReward(int blockReward) {
        this.blockReward = blockReward;
    }
}
