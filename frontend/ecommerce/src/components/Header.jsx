import React from 'react'
import { Link } from 'react-router-dom'

const Header = () => {
  return (
    <header className="bg-white shadow-md sticky top-0 z-50">
      <div className="max-w-7xl mx-auto px-4 py-3 flex items-center justify-between">
        {/* Logo */}
        <div className="text-xl font-bold text-blue-600">
          Shop<span className="text-gray-800">Ease</span>
        </div>

        {/* Navigation */}
        <nav className="hidden md:flex space-x-6 text-gray-600 font-medium">
          <Link to="/" className="hover:text-blue-600">Home</Link>
          <Link to="/" className="hover:text-blue-600">Shop</Link>
          <Link to="#" className="hover:text-blue-600">Contact</Link>
        </nav>

        <div className="flex items-center space-x-4">
          <button className="px-4 py-1 text-sm font-medium text-white bg-blue-600 rounded hover:bg-blue-700">
            Login
          </button>
          <button className="px-4 py-1 text-sm font-medium text-blue-600 border border-blue-600 rounded hover:bg-blue-50">
            Register
          </button>



        </div>
      </div>
    </header>
  )
}

export default Header