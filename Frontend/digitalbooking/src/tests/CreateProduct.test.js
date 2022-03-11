import React from 'react';
import { mount, shallow } from 'enzyme';
import { CreateProduct } from '../components/CreateProduct/CreateProduct'
import '@testing-library/jest-dom'
import { expect } from '@jest/globals';

jest.mock('react-router-dom', () => ({
  useParams: jest.fn().mockReturnValue({ nifUuid: 'nif123' }),
  useHistory: jest.fn(),
  useLocation:jest.fn().mockReturnValue({
    pathname: "/register",
    search: "",
    hash: "",
    state: null,
    key: "5nvxpbdafa",
  }),
}));
const bearer = JSON.stringify({jwt:"Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkaEpXVCIsInN1YiI6ImFndXNAZGguY29tIiwiaWQiOjQsIm5hbWUiOiJBZ3VzdGluYSBQYXNxdWFsaXMiLCJhdXRob3JpdGllcyI6WyJVU0VSIl0sImlhdCI6MTYzNzYxNTQ4MywiZXhwIjoxNjM3NzAxODgzfQ.71eZCOY3cJHr0wlHCmzEt6sbNRoXulY5ki0y8eP2T3Q"});

const localStorageMock = (function() {
  let store = {};
  
  return {
    getItem(key) {
      return store[key];
    },
 
    setItem(key, value) {
      store[key] = value;
    },
  
    clear() {
      store = {};
    },

    removeItem(key) {
      delete store[key];
    },
     
    getAll() {
     
    }
  };
})();

Object.defineProperty(window, 'localStorage', { value: localStorageMock });
const user = {jti:"dhJWT", sub:"agus@dh.com", id:4,name:"Agustina Pasqualis", authorities:["ADMIN"]};

describe('Pruebas en componente <CreateProduct/>', ()=> {
    const jsonId = 'data';
    const newJson = {data: user};
    window.localStorage.setItem(jsonId, JSON.stringify(newJson));
    const jsonId2 = 'bearer';
    const newJson2 = {bearer: bearer};
    window.localStorage.setItem(jsonId2, JSON.stringify(newJson2));
    const wrapper= mount(<CreateProduct />);

    test('Comprobar que <CreateProduct/> renderiza correctamente.', () => {
    
        expect( wrapper ).toMatchSnapshot();
      
    })

   
    
})