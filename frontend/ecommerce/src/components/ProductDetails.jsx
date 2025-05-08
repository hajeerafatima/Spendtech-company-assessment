import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import Header from './Header';
import { Link } from 'react-router-dom';

const ProductDetails = () => {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    console.log("Fetching product with ID:", id);
    fetch(`http://localhost:8080/api/products/product/${id}`)
      .then((res) => {
        if (!res.ok) throw new Error("Product not found");
        return res.json();
      })
      .then((data) => setProduct(data))
      .catch((err) => {
        console.error("Error fetching product:", err);
        setError("Product not found");
      });
  }, [id]);

  if (error) return <p className="text-red-500">{error}</p>;
  if (!product) return <p>Loading...</p>;

  return (
    <>
    <Header/>
    <div className="max-w-5xl mx-auto p-6">
  <div className="flex flex-col md:flex-row gap-6">
    {/* Image Section */}
    <div className="md:w-1/2">
      <img 
        src={product.imageUrl} 
        alt={product.name} 
        className="w-full h-96 object-cover rounded-lg shadow" 
      />
    </div>

    {/* Details Section */}
    <div className="md:w-1/2 flex flex-col justify-center">
      <h1 className="text-3xl font-bold mb-4">{product.name}</h1>
      <p className="text-gray-700 mb-4">{product.description}</p>
      <p className="text-2xl text-green-600 font-semibold">${product.price}</p>

      <div className="flex gap-4">
        <Link to="/">
          <button className="bg-gray-500 text-white px-4 py-2 rounded hover:bg-gray-600"
            onClick={() => navigate("/")}
          >
            Back to Home
          </button>
        </Link>
        <button className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">
          Order Now
        </button>
      </div>

    </div>
  </div>
      </div>
    </>
  );
};

export default ProductDetails;

