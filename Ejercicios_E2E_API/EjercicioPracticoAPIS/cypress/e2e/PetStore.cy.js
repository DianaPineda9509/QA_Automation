describe('Testing API - Petstore.', () => {

  it('Create User.', () => {
    cy.request({
      url: 'https://petstore.swagger.io/v2/user', 
      method:'POST',
      body:{
              username: "dianampineda",
              firstName: "Diana",
              lastName: "Pineda",
              email: "diana@gmail.com",
              password: "123456",
              phone: "3017960374",
              userStatus: "0"
          }
      }).then(response=>{
          expect(response.status).to.be.eq(200)

      })
  })

  it('Validate User.', function () {
    cy.request("GET",`https://petstore.swagger.io/v2/user/dianampineda`).then(response => {
        expect(response.status).to.be.eq(200)
    })
  });

it('Update User.', function () {
  cy.request({
      url: `https://petstore.swagger.io/v2/user/dianampineda`, 
      method:"PUT",
      body:{
              username: "dianampineda1",
              email: "diana.pruebas9509@gmail.comm"
          }
      }).then(response=>{
          cy.log(response)
          expect(response.status).to.be.eq(200)
      })
});

it('Validate User Update.', function () {
  cy.request("GET",`https://petstore.swagger.io/v2/user/dianampineda1`).then(response => {
      expect(response.status).to.be.eq(200)
  })
});

it("Delete User.", function () {
  cy.request({
    url: `https://petstore.swagger.io/v2/user/dianampineda1`,
    method: "DELETE",
  }).then((response) => {
    expect(response.status).to.eq(200);
  })
});



})