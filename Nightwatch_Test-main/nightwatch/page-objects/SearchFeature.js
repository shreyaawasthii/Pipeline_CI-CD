module.exports = {
    elements: {
      productsLink: {
        selector: '//a[contains(text(), "Products")]',
        locateStrategy: 'xpath',
      },
      searchInput: 'input[name="search"]',
      searchButton: 'button#submit_search',
      searchResultsTitle: '.title.text-center',
    },
    // commands: {
    //   performSearch(query) {
    //     this.api
    //     .assert.visible('@productsLink')
    //     .click('@productsLink')
    //     .assert.visible('@searchInput')
    //     .setValue('@searchInput', query)
    //     .click('@searchButton')
    //     .assert.containsText('@searchResultsTitle', 'SEARCHED PRODUCTS');
    //     return this;
    //   },
    // },
  };