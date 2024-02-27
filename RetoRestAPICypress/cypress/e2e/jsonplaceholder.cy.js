import { schemaPlaceHolderList } from './schemas/schemaspost'
import { schemaPlaceHolderListone } from './schemas/schemasone'

describe('Pruebas para restAPI - PlaceHolder.', () => {

  it('Obtener los Placeholder posts.', () => {
    
    const url = 'https://jsonplaceholder.typicode.com/posts'
    const methodRest = 'GET'
    cy.requestSend(methodRest, url, null, 200, schemaPlaceHolderList)

  })

  it('Obtener los Placeholder posts 1 comments.', () => {
    
    const url = 'https://jsonplaceholder.typicode.com/posts/1/comments'
    const methodRest = 'GET'
    cy.requestSend(methodRest, url, null, 200, schemaPlaceHolderListone)

  })

})