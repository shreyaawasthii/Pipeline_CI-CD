module.exports = {
  elements: {
    loginLink: {
      selector: '//a[contains(text(), "Login")]',
      locateStrategy: 'xpath',
    },
    emailInput: 'input[data-qa="login-email"][name="email"]',
    passwordInput: 'input[name="password"]',
    loginButton: 'button[data-qa="login-button"]',
    logoutLink: {
      selector: '//a[contains(text(), "Logout")]',
      locateStrategy: 'xpath',
    },
  },
  // commands: {
  //   performLogin(email, password) {
  //     this.api
  //       .waitForElementVisible('@loginLink')
  //       .click('@loginLink')
  //       .waitForElementVisible('@emailInput')
  //       .setValue('@emailInput', email)
  //       .waitForElementVisible('@passwordInput')
  //       .setValue('@passwordInput', password)
  //       .click('@loginButton')
  //       .waitForElementVisible('@logoutLink');

  //     return this.api;
  //   },
  // },
};
