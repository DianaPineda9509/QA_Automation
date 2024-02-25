import { schemaPlaceHolderList } from './schemas'

describe('Pruebas para restAPI - PlaceHolder.', () => {

  it('Obtener los Placeholder.', () => {
    
    const url = 'https://jsonplaceholder.typicode.com/todos'
    const methodRest = 'GET'
    cy.requestSend(methodRest, url, null, 200, schemaPlaceHolderList)

  })

})