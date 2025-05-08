import React from 'react'
import { Link } from 'react-router-dom'

const ProductList = ({ products }) => {
  return (
    <>
  
    <div className="flex flex-wrap -mx-4">
    {products.map(product => (
      <div key={product.id} className="w-full sm:w-1/2 lg:w-1/3 px-4 mb-4">
        <Link to={`/product/${product.id}`}>
          <div className="bg-white rounded-lg shadow h-full flex flex-col hover:shadow-lg transition">
            <img
              className="w-full h-80 object-cover rounded-t"
              src={product.imageUrl || 'https://placehold.co/600x400'}
              alt={product.name}
            />
            <div className="p-4">
              <h5 className="text-lg font-semibold mb-2">{product.name}</h5>
              <p className="text-gray-700 mb-2">{product.description}</p>
              <p className="text-gray-900 font-bold">${product.price}</p>
            </div>
          </div>
        </Link>
      </div>
    ))}
  </div>
  </>
  )
}

export default ProductList