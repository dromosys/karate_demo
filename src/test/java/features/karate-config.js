function() {
    var config = {
        // base config
    };

    if (karate.env == 'gatling') {
        config.gatling = {
            // Gatling specific configuration
        };
    }

    return config;
}