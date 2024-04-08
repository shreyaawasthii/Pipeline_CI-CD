module.exports = {
    elements: {
      productLink: {
        selector: 'a[href="/product_details/4"]',
        locateStrategy: 'xpath',
      },
      viewProduct: '.view-product',
      quantityInput: '#quantity',
      addToCartButton: '.btn.btn-default.cart',
      modalTitle: '.modal-title.w-100',
      viewCartButton: '.modal-body a[href="/view_cart"]',
      checkoutButton: '.btn.btn-default.check_out',
    },
    // commands: {
    //   purchaseProduct(quantity) {
    //     this.api
    //     .assert.visible('@productLink')
    //     .click('@productLink')
    //     .assert.visible('@viewProduct')
    //     .setValue('@quantityInput', quantity)
    //     .click('@addToCartButton')
    //     .waitForElementPresent('@modalTitle')
    //     .assert.visible('@modalTitle')
    //     .click('@viewCartButton')
    //     .assert.visible('@checkoutButton')
    //     .click('@checkoutButton');
    //     return this;
    //   },
    // },
  };