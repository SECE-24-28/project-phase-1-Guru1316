public class Production {
    String producerName;
    String productionCompany;
    String directorName;

    Production(String producer, String company, String director) {
        this.producerName = producer;
        this.productionCompany = company;
        this.directorName = director;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }


}